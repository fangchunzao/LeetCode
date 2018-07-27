package com.leetcode.one;

/**
 *  最长公共前缀
 *
 *  通过判断数组中字符串 每一位是否相同
 */
public class LeetCode14 {

    public static void main(String[] args) {
        String[] strArr = {"aa","a"};
        System.out.println(longestCommonPrefix(strArr));
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) return ""; // 空数组
        if (strs.length == 1) return strs[0];
        for (int l = 0; l < strs[0].length(); l++) {  //循环验证字符串第几个
            String prevStr = "";
            for (int i = 0; i < strs.length; i++) { // 循环数组
                if (strs[i].length()-1 < l) {  // 边界类型 {"aa","a"} 第一位数组长度大于第二位
                    return result;
                }
                // 判断当前字符与上一次字符是否相同
                String str = strs[i].substring(l, l + 1);
                if (i > 0 && !str.equals(prevStr)) { // 第一个数组不判断 出现不同直接返回结果
                    return result;
                }
                if (i == strs.length - 1 && str.equals(prevStr)) { // 循环到最后一个数组
                    result += str;
                }
                prevStr = str;
            }
        }
        return result;
    }
}
