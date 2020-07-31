package com.leetcode.iv.dic;

/**
 * description 面试题 08.11. 硬币
 *
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-28 20:13:35
 */
public class StartDic08_11 {

    // 动态规划
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1,5,10,25};
        dp[0] = 1;
        // dp方程：dp[i] += dp[i - coin];
        // 考虑到硬币的顺序问题 (1,5) (5,1) 是一种，需要先遍历Coins
        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }















    public int waysToChange1(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{25,10,5,1};

        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for(int coin : coins) {
                // 面额太大的硬币
                if (coin > i) continue;
                dp[i] += dp[i - coin];
            }
        }
        return dp[n];
    }

}
