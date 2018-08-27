package com.leetcode.junior.string;

/**
 * @Auther: FCZ
 * @Description: 有效的字母异位词
 *  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * @Date: 2018/8/24 14:39
 */
public class String4 {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        System.out.println(isAnagram(s1, s2));

    }

    /**
     * 哈希表解决
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] hashTable = new int[26];

        for (int i = 0; i < s.length(); i++)
            hashTable[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++) {
            if (hashTable[t.charAt(i) - 'a'] > 0) {
                hashTable[t.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }

        int sum = 0;
        for (int i = 0; i < hashTable.length; i++)
            sum += hashTable[i];

        if (sum == 0) return true;

        return false;

    }
}
