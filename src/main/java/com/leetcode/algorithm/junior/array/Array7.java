package com.leetcode.algorithm.junior.array;

import java.util.Arrays;

/**
 *  加一
 *
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Array7 {

    public static void main(String[] args) {
        int[] a1 = {1,2,9,9};
        int[] a2 = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(plusOne(a2)));
//        System.out.println(Arrays.toString(plusOne(new int[10])));
    }

    public static int[] plusOne(int[] digits) {
        int flag = 1;

        for (int i = digits.length - 1; i >= 0 ; i--) {
            if (flag == 0) { // 不存在 进一位情况 返回
                return digits;
            }
            int value = digits[i] + flag;
            flag = value / 10;  // 判断此次数字是否大于10  需要进一位
            digits[i] = value % 10;
        }

        if (flag == 1) {  // 说明全是9 数组需要扩容
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
