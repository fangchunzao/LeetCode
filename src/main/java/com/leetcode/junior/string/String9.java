package com.leetcode.junior.string;

/**
 * @Auther: FCZ
 * @Description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Date: 2018/9/11 14:38
 */
public class String9 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    // 数组中第一个字符串作为标准，循环判断其他字符串的字符与其是否相同
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String result = "";

        for (int l = 0; l < strs[0].length(); l++) {
            String prevStr = "";  //前一个字符
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length()-1 < l) {
                    return result;
                }
                String str = strs[i].substring(l, l + 1);
                if (i > 0 && !str.equals(prevStr)) { // 遍历除第一个字符的其他字符时，如果不同，直接返回
                    return result;
                }
                // 遍历到最后一位 并且相同
                if (i == strs.length - 1 && str.equals(prevStr)) {
                    result += str;
                }
                prevStr = str;
            }
        }
        return result;
    }
}
