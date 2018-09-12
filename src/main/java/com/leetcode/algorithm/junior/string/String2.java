package com.leetcode.algorithm.junior.string;

/**
 * @Auther: FCZ
 * @Description: 颠倒整数
 *  给定一个 32 位有符号整数，将整数中的数字进行反转。
 * @Date: 2018/8/23 10:46
 */
public class String2 {

    public static void main(String[] args) {

    }

    public static int reverse(int x) {
        long result = 0L;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }


}
