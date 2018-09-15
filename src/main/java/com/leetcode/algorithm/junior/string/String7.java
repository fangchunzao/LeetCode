package com.leetcode.algorithm.junior.string;

/**
 * @Auther: FCZ
 * @Description:
 * @Date: 2018/9/11 13:52
 */
public class String7 {

    public static void main(String[] args) {
        String haystack = "aaa", needle = "aaaa";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if ("".equals(haystack) && "".equals(needle)) return 0;
        if ("".equals(needle)) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                char s1 = haystack.charAt(i + j);
                char s2 = needle.charAt(j);
                if (s1 != s2) break;
                if (s1 == s2 && j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
