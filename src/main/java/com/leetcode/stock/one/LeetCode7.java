package com.leetcode.stock.one;

/**
 * @author FangChunZao
 * @Description: 反转整数
 * @date 2018/7/18
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 */
public class LeetCode7 {

    public static void main(String[] args) {
        System.out.println(reverse(-12345678));
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
