package com.leetcode.iv.offer;

public class Offer49 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));

    }


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
