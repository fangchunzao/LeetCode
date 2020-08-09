package com.leetcode.iv.dic;

/**
 * description 面试题 16.10. 生存人数
 *
 * 给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]，实现一个方法以计算生存人数最多的年份。
 *
 * 你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。
 * 如果一个人在某一年的任意时期都处于生存状态，那么他们应该被纳入那一年的统计中。
 * 例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。
 *
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 *
 * 示例：
 *
 * 输入：
 * birth = {1900, 1901, 1950}
 * death = {1948, 1951, 2000}
 * 输出： 1901
 * 提示：
 *
 * 0 < birth.length == death.length <= 10000
 * birth[i] <= death[i]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/living-people-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-08-09 14:35:27
 */
public class Dic16_10 {

    // 动态规划
    public int maxAliveYear(int[] birth, int[] death) {
        // 动态规划 1900-2000 每一年的最大人数
        // 数组增大一个是因为死亡人数当年也算一个 第二年再减去
        int[] dp = new int[102];
        for(int b : birth)
            dp[b - 1900]++;
        for(int d : death)
            dp[d - 1900 + 1]--;
        // 计算出每一年的人数 并找出最大值
        int maxValue = dp[0], maxYear = -1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            if (dp[i] > maxValue) {
                maxValue = dp[i];
                maxYear = i + 1900;
            }
        }
        return maxYear;
    }

}
