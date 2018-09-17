package com.leetcode.train.binary_search;

/**
 * @Description: Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 */
public class Summary1 {

    public static void main(String[] args) {

    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        double half = myPow(x, n / 2);
        if (n % 2 == 0) return half * half; // n/2 n是双数，能整除
        else if (n > 0) return half * half * x;  // n/2 n是单数，需要加1个
        else return half * half / x; // n是负数
    }

}
