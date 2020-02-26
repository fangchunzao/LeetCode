package com.leetcode.iv.bd;


/**
 * @author fcz
 * @description
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @date 2020-02-24 14:42
 **/
public class ByteDance5 {

    public static void main(String[] args) {
        ByteDance5 obj = new ByteDance5();
        System.out.println(obj.reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        if (s.length() == 0) return "";

        String[] splitString = s.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = splitString.length - 1; i >= 0; i--) {
            if ("".equals(splitString[i]) || " ".equals(splitString[i])) continue;
            if (result.length() == 0)
                result.append(splitString[i]);
            else
                result.append(" ").append(splitString[i]);
        }
        return result.toString();
    }


}
