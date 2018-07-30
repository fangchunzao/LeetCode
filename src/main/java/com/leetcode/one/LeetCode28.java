package com.leetcode.one;

/**
 * 28. 实现strStr()
 *
 *  实现 strStr() 函数。
 *
 *  给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class LeetCode28 {

    public static void main(String[] args) {
        String s = "a";
        String b = "";
        System.out.println(strStr("aaa",""));

    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if ("".equals(haystack) && "".equals(needle)) return 0;
        if ("".equals(needle)) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // 第一位相同
            for (int j = 0; j < needle.length(); j++){
                char s1 = haystack.charAt(i + j);
                char s2 = needle.charAt(j);
                if (s1 != s2) {
                    break;
                }
                if (s1 == s2 && j == needle.length() - 1) {  // 匹配到最后一位
                    return i;
                }
            }

        }
        return -1;
    }
}
