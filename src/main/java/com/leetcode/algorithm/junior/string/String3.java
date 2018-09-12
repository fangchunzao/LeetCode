package com.leetcode.algorithm.junior.string;

/**
 * @Auther: FCZ
 * @Description:  字符串中的第一个唯一字符
 *  给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @Date: 2018/8/23 10:48
 */
public class String3 {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    /**
     * 字母共有26个，维护一个数组，统计每个字母出现的次数。
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int[] contrastTable = new int[26];

        for (int i = 0; i < s.length(); i++)
            contrastTable[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (contrastTable[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
