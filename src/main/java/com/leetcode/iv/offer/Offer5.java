package com.leetcode.iv.offer;

/**
 * 面试题05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @see com.leetcode.iv.dic.Dic01_03 原题
 *
 * @since 2020-07-02 复习
 *
 */
public class Offer5 {

    public static void main(String[] args) {

    }

    // 直接使用自带函数
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    //
    public String replaceSpace1(String s) {

        // 创建新的数组 放结果 因为一个字符会变成3个字符 最坏情况 *3
        char[] array = new char[s.length() * 3];
        int size = 0; // 记录数组长度
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = ch;
            }
        }
        return new String(array, 0, size);
    }

}
