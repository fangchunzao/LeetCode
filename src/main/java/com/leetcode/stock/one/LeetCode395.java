package com.leetcode.stock.one;

/**
 * 395. 至少有K个重复字符的最长子串
 *
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/10/16 14:43
 **/
public class LeetCode395 {

    public static void main(String[] args) {
        LeetCode395 obj = new LeetCode395();
        System.out.println(obj.longestSubstring("aaabb", 3));
    }

    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) return 0;
        if (k < 2) return len;
        return longestSubstring(s.toCharArray(), k, 0, len - 1);
    }

    public int  longestSubstring(char[] s, int k, int low, int high) {
        if (high - low + 1 < k) return 0;
        // 计算每个字母出现的次数 哈希表解决
        int[] count = new int[26];
        for (int i = low; i <= high; i++) {
            count[s[i] - 'a']++;
        }
        // 如果该字符出现频次小于k，则不可能出现在结果子串中
        // 从头尾指针分别进行判断
        while (high - low + 1 >= k && count[s[low] - 'a'] < k) {
            low++;
        }
        while (high - low + 1 >= k && count[s[high] - 'a'] < k) {
            high--;
        }
        if (high - low + 1 < k) return 0;
        // 缩小范围后 字符串中间可能出现不满足条件的串 循环判断 找出不满足的地方 进行分割 递归
        for (int i = low; i <= high; i++) {
            if (count[s[i] - 'a'] < k) {
                return Math.max(longestSubstring(s, k, low, i - 1),longestSubstring(s, k, i + 1, high));
            }
        }
        return high - low + 1;
    }
}
