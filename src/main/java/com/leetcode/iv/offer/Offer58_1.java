package com.leetcode.iv.offer;

/**
 * description 面试题58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fcz
 * @since  2020-06-09 10:41
 **/
public class Offer58_1 {

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }

    /**
     * 双指针 算法面试中使用 建议
     */
    public static String reverseWords(String s) {
        // 去掉首尾空格
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            // 从后往前 找到第一个单词的开头 也就是第一个空格
            while (i >= 0 && s.charAt(i) != ' ')
                i--;
            // 添加单次
            sb.append(s, i + 1, j + 1).append(" ");
            // 跳过多余的空格
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            // j指向了下一个单次的尾字母
            j = i;
        }
        return sb.toString().trim();
    }

    /**
     * 库函数 虽然更快 但是不推荐算法面试中使用
     * 拆分字符串 然后倒序输出
     */
    public String reverseWords1(String s) {
        // 删除首尾空格，分割字符串
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        // 倒序遍历单词列表
        for(int i = strs.length - 1; i >= 0; i--) {
            // 遇到空单词则跳过
            if(strs[i].equals(""))
                continue;
            // 将单词拼接至 StringBuilder
            res.append(strs[i]).append(" ");
        }
        // 转化为字符串，删除尾部空格，并返回
        return res.toString().trim();
    }


}

