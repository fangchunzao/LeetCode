package com.leetcode.train.array;

/**
 * @author FCZ
 * @since 2018/10/30 16:21
 *  加一
 *  给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 */
public class Array4 {

    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        int flag = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (flag == 0) {
                return digits;
            }
            int value = digits[i] + flag;
            flag = value / 10;
            digits[i] = value % 10;
        }
        if (flag == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
