package com.leetcode.stock.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/11/13 10:52
 **/
public class LeetCode5 {

    public static void main(String[] args) {
        LeetCode5 obj = new LeetCode5();
        System.out.println(obj.longestPalindrome2("babad"));
    }

    public String longestPalindrome(String s) {

       return "";
    }

    // 最长公共子串
    // 根据回文串的定义，正着和反着读一样，那我们是不是把原来的字符串倒置了，然后找最长的公共子串就可以了
    public String longestPalindrome1(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        // 动态规划 求出最长公共字符子串
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                // 求出最长公共子串后，并不一定是回文串
                // S="abc435cba"，S="abc534cba"，最长公共子串是 "abc" 和 "cba"，但很明显这两个字符串都不是回文串。
                // 我们只需要判断末尾字符就可以。
                if (arr[i][j] > maxLen) {
                    /**
                     *   S1 = c a b a  S' = a b a c
                     *   1. 找到最长公共子串 i = 3 , j = 2
                     *   2. 找到 S'的初始位置 length - 1 - j (3 - 1- 2) = 0
                     *   3. S'初始位置 + 最长子串 - 1 = i的位置
                     */
                    int beforeRev = length - 1 - j;

                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }



    // 中心扩展算法
    //    作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    // 我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
