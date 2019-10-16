package com.leetcode;

/**
 * 动态规划  数塔问题
 *
 * 一个数塔，从顶部出发在每一个节点可以选择向左或者向右走，一直走到底层，要求找出一条路径，使得路径上的数字之和最大.
 *
 *
 * @author Mr.F
 * @since 2019/10/16 16:57
 **/
public class DP1 {

    public static void main(String[] args) {

    }

    /**
     * 原数组
     *            9
     *         12   15
     *      10	 6	  8
     *    2	  18   9    5
     * 19	7	10	 4	 16
     *
     * dp数组
     *           59
     *        50   49
     *      38	34	 29
     *   21	  28  19   21
     * 19	7	10	4	 16
     *
     * 使用动态规划 从下到上进行计算 每个节点获取下层子节点的最大值，相加保存到当前节点 。 递归执行到顶层就出来结果了
     *
     * @param data
     */

    public void tower(int[][] data) {
        int[][] dp = new int[data.length][data[0].length];
        int n = data.length;
        // dp初始化 最下面一行初始化
        for (int i = 0; i < n; ++i) {
            dp[n - 1][i] = data[n - 1][i];
        }
        int temp_max;
        // 从下到上
        for (int i = n - 1; i >= 0; --i) {
            // 从左到右
            for (int j = 0; j <= i; ++j) {
                // 使用递推公式计算dp的值  由下到上计算
                // 通过下层的两个数字选出最大值
                temp_max = Math.max(dp[i][j], dp[i][j + 1]);
                dp[i][j] = temp_max + data[i][j];
            }
        }

    }

}
