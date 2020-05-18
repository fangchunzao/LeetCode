package com.leetcode.stock.one;

/**
 * @author fcz
 * @description 151. 翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
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
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020-04-10 15:24
 **/
public class LeetCode151 {

    public static void main(String[] args) {
        LeetCode151 obj = new LeetCode151();
        System.out.println(obj.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) return s;

        // 按照空格分隔
        String[] ss = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0 ; i--) {
            String str = ss[i];
            // 当前元素不为空 添加到字符串中
            if (!str.trim().equals("")) {
                sb.append(str).append(" ");
            }
        }
        // 最后一位是空格 需要删除
        return sb.toString().substring(0, sb.length() - 1);
    }

}
