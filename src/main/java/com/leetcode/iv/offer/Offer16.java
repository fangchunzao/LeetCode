package com.leetcode.iv.offer;

/**
 * 面试题16. 数值的整数次方
 *
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-09 复习
 *
 */
public class Offer16 {

    public double myPow(double x, int n) {
        if (n == 0) return 1;

        int absN = Math.abs(n);
        double absX = x;
        while (--absN > 0)
            absX *= x;

        if (n < 0){
            absX = 1 / absX;
        }
        return absX;
    }

    // 二分法
    public double myPow1(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        // 偶数情况
        double half = myPow1(x, n / 2);
        // 奇数情况
        double mod = myPow1(x, n % 2);
        return half * half * mod;
    }

    // “二分法” 和 “二进制”
    // 作者：jyd
    // 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
    public double myPow2(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            // 运算到末尾 计算完成 保存结果
            if((b & 1) == 1) res *= x;
            x *= x;
            // 使用位运算进行 二分
            b >>= 1;
        }
        return res;
    }


}
