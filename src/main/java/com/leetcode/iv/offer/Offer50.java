package com.leetcode.iv.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description 面试题50. 第一个只出现一次的字符
 *
 *在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since  2020-06-03 09:25
 *
 * @since 2020-08-18 复习
 **/
public class Offer50 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aadadaad"));
    }

    /**
     * 哈希表 使用一个数组代替哈希表
     * 速度最快 减少了Map数据结构带来的耗时
     */
    public static char firstUniqChar(String s) {
        int[] hash = new int[26];
        char[] strChar = s.toCharArray();
        for(char ch : strChar) {
            hash[ch - 'a']++;
        }
        for(char ch : strChar) {
            if (hash[ch - 'a'] == 1)
                return ch;
        }
        return ' ';
    }


    /**
     * String内置方法
     * 找出 字符串中 ch 的前后位置 判断是否相同 就可以判断出是否多次出现过
     *
     * 相比于哈希表快一点
     */
    public static char firstUniqChar1(String s) {
        for(char ch : s.toCharArray()) {
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return ch;
            }
        }
        return ' ';

    }

    // 哈希表的耗时都差不多
    /**
     * 哈希表
     * 哈希表中放入( char - 是否多次出现)
     * 然后循环原字符串 找出第一个只出现一次的
     */
    public static char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }


    /**
     *  有序哈希表
     *  哈希表中放入( char - 是否多次出现)
     *  找出哈希表中第一个true
     */
    public char firstUniqChar3(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

    /**
     * 有序哈希表
     * 首先 哈希表中放入 （char - 出现次数）
     * 然后 判断出哈希表中第一个出现次数为一次的
     */
    public static char firstUniqChar4(String s) {
        if (s == null || s.length() == 0)
            return ' ';

        Map<Character, Integer> map = new LinkedHashMap<>();
        for(Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        char res = ' ';
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
                break;
            }
        }
        return res;

    }

}
