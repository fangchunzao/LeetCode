package com.leetcode.iv.bd;

/**
 *  字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class ByteDance3 {

    public static void main(String[] args) {

    }

    // 使用数组哈希表
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] hash1 = new int[26];
        // 将s1字符串放入hash表中
        for (int i = 0; i < s1.length(); i++) {
            hash1[s1.charAt(i) - 'a']++;
        }
        // s2数组往右移
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] hash2 = new int[26];  // s2 哈希表
            // s2 数组每次移动 s1的长度 保存入s2 哈希表
            for (int j = 0; j < s1.length(); j++) {
                hash2[s2.charAt(i + j) - 'a']++;
            }
            // 判断hash1 与 hash2 是否相同
            if (matches(hash1, hash2))
                return true;
        }
        return false;
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }



}
