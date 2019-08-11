package com.leetcode.stock.one;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 */
public class LeetCode387 {

    public int firstUniqChar(String s) {
        int[] hashTable = new int[200];
        for (int i = 0; i < s.length(); i++) {
            int count = hashTable[s.charAt(i)];
            count++;
            hashTable[s.charAt(i)] = count;
        }

        for (int i = 0; i < s.length(); i++) {
            int result = hashTable[s.charAt(i)];
            if (result == 1)
                return i;
        }
        return -1;
    }

}
