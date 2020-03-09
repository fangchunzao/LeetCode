package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class StartLeetCode332 {

    public static void main(String[] args) {
        StartLeetCode332 obj = new StartLeetCode332();
        //        [186,419,83,408]
        //6249
        System.out.println(obj.coinChange1(new int[] {186,419,83,408}, 6249));
    }

    // 动态规划
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // dp数组表示的为 每一位所需要硬币的最小数
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 贪心 回溯
    private int minResult = Integer.MAX_VALUE;
    // 先排序 从硬币数组的右边到左边 依次进行 除法操作
    // 算出使用当前硬币最大可能次数
    // 不符合条件时 将次数-1 进行回溯
    //
    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins); // asc
        coinChange1(coins, coins.length - 1, amount, 0);
        return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }

    /**f
     *
     * @param coins 硬币数组
     * @param amount 总金额
     * @param index 数组索引
     * @param cnt 使用的硬币数量
     */
    private void coinChange1(int[] coins, int amount, int index, int cnt) {
        if (index < 0) return;
        // amount / coins[index] 当前使用硬币的最大可能次数 大概率不会直接符合条件 因此使用回溯进行递减
        for (int i = amount / coins[index]; i >= 0; i--) {
            // 计算 剩下的数还有多少   总数-(最大个数*当前数)
            int currRest = amount - i * coins[index],
                    // 使用当前硬币的次数
                    currCnt = cnt + i;
            // currCnt + 1 因为剩下的金额不为0 因此最少还要+1次
            if (currRest > 0 && currCnt + 1 < minResult)
                coinChange1(coins, currRest, index - 1, currCnt);
            else {
                if (currRest == 0 && currCnt < minResult)
                    minResult = currCnt;
                // 已经找到当前硬币个数为 i 时的最小值，再继续分解，数量只会增加 减少递归次数 break
                break;
            }
        }
    }

}
