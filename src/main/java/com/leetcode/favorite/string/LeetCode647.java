package com.leetcode.favorite.string;

/**
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * https://leetcode.cn/problems/palindromic-substrings/
 */
public class LeetCode647 {

    public static void main(String[] args) {
        LeetCode647 obj = new LeetCode647();
        System.out.println(obj.countSubstrings("abc"));
    }

    // 动态规划法
    public int countSubstrings2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    // 中心扩展 最优
    private int count = 0;

    public int countSubstrings3(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);
            extendSubstrings(s, i, i + 1);
        }
        return count;
    }

    private void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
    }


    //
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++) {
            countSubstrings(s.toCharArray(), i);
        }
        return count;
    }


    public void countSubstrings(char[] chars, int index) {
        if(index >= chars.length) {
            return;
        }
        for(int i = index; i < chars.length; i++) {
            if(check(chars, index, i)) {
                count++;
            }
        }
    }

    public boolean check(char[] chars, int start, int end) {
        if(end >= chars.length) {
            return false;
        }
        while(start < end) {
            if(chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
