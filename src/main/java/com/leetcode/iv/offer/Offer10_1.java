package com.leetcode.iv.offer;

/**
 * 面试题10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer10_1 {

    public static void main(String[] args) {
        Offer10_1 obj = new Offer10_1();
        System.out.println(obj.fib1(44));
    }

    // 回溯 超时
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // 动态规划 算法
    public int fib1(int n) {
        if (n <= 1) return n;
        int dp1 = 0;
        int dp2 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (dp1 + dp2) % 1000000007;
            dp1 = dp2;
            dp2 = res;
        }
        return res == 1000000008 ? 1 : res;
    }


}
