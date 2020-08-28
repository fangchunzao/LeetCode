package com.leetcode.iv.offer;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * @since 2020-08-18 复习
 *
 */
public class Offer49 {

    // 设想得出 n+1 可能的存在为 (x1 * 2)  (x2 * 3) (x3 * 5)  如果 x1 x2 x3 都存在 那么取最小的值
    // 并且 x1 x2  x3 肯定是小于 n + 1 的丑数。 通过动态规划可解
    public static int nthUglyNumber(int n) {
        int x1 = 0, x2 = 0, x3 = 0;
        // 下标从0开始 代表第一个丑数
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 得出三个最近的丑数
            int ugly1 = dp[x1] * 2;
            int ugly2 = dp[x2] * 3;
            int ugly3 = dp[x3] * 5;
            // 最小的丑数就是下一个丑数
            dp[i] = Math.min(Math.min(ugly1, ugly2), ugly3);
            // 判断哪一个被选择了 哪一个+1
            if (dp[i] == ugly1)
                x1++;
            if (dp[i] == ugly2)
                x2++;
            if (dp[i] == ugly3)
                x3++;
        }
        return dp[n-1];
    }


}
