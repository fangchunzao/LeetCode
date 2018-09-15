package com.leetcode.algorithm.junior.string;

/**
 * @Auther: FCZ
 * @Description: 编写一个函数，其作用是将输入的字符串反转过来。
 * @Date: 2018/8/23 10:19
 */
public class String1 {

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseString(s));
    }

    /**
     * 定义两个指针指向两边，两边换位
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            char temp = s.charAt(left);
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return String.valueOf(chars);
    }
}
