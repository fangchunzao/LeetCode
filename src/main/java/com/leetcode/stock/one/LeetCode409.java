package com.leetcode.stock.one;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fcz
 * @description 409. 最长回文串
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @date 2020-03-19 09:53
 **/
public class LeetCode409 {

    public static void main(String[] args) {
    }

    Map<Character, Integer> map = new HashMap<>();
    // 哈希表
    public int longestPalindrome(String s) {
        for(char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c,1);
            }
        }
        int length = 0;
        boolean flag = false;
        for(Integer i : map.values()) {

            if (i % 2 == 1) {
                if (!flag)
                    length++;
                flag = true;
                length += i - 1;
            } else {
                length += i;
            }
        }
        return length;
    }

    // 哈希表 使用int
    public int longestPalindrome2(String s) {
        int[] hash = new int[58];
        for(char c : s.toCharArray()) {
            hash[c - 'A'] ++;
        }
        int length = 0;
        for (int count : hash) {
            // 单数少一个
            length += count - (count % 2);
        }
        // 如果计算长度小于总长度 说明存在负数 +1 放在中间
        return length < s.length() ? length + 1 : length;
    }

    // 单次遍历
    public int longestPalindrome1(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        char[] sc = s.toCharArray();
        Arrays.sort(sc);

        int preIndex = 0, i = 1;
        int length = 0;
        boolean flag = false;
        for (; i < sc.length; i++) {
            if (sc[preIndex] != sc[i]) {
                int position = i - preIndex;
                if (position % 2 == 1) flag = true;
                length += i - preIndex - (position % 2 );
                preIndex = i;
            }
        }
        if ((i - preIndex) % 2 == 1) flag = true;
        length += i - preIndex - ((i - preIndex) % 2 );
        return flag ? length + 1 : length;
    }

}
