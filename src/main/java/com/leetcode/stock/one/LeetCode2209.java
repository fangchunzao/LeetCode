package com.leetcode.stock.one;

/**
 * ClassName: LeetCode2209
 * Description:
 * 给你一个下标从 0 开始的 二进制 字符串 floor ，它表示地板上砖块的颜色。
 *
 * floor[i] = '0' 表示地板上第 i 块砖块的颜色是 黑色 。
 * floor[i] = '1' 表示地板上第 i 块砖块的颜色是 白色 。
 * 同时给你 numCarpets 和 carpetLen 。你有 numCarpets 条 黑色 的地毯，每一条 黑色 的地毯长度都为 carpetLen 块砖块。请你使用这些地毯去覆盖砖块，使得未被覆盖的剩余 白色 砖块的数目 最小 。地毯相互之间可以覆盖。
 *
 * 请你返回没被覆盖的白色砖块的 最少 数目。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：floor = "10110101", numCarpets = 2, carpetLen = 2
 * 输出：2
 * 解释：
 * 上图展示了剩余 2 块白色砖块的方案。
 * 没有其他方案可以使未被覆盖的白色砖块少于 2 块。
 * 示例 2：
 *
 *
 *
 * 输入：floor = "11111", numCarpets = 2, carpetLen = 3
 * 输出：0
 * 解释：
 * 上图展示了所有白色砖块都被覆盖的一种方案。
 * 注意，地毯相互之间可以覆盖。
 *
 *
 * 提示：
 *
 * 1 <= carpetLen <= floor.length <= 1000
 * floor[i] 要么是 '0' ，要么是 '1' 。
 * 1 <= numCarpets <= 1000
 *
 * @author chunzao
 * @date 2025/2/21 10:04
 * @since https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/description/?envType=daily-question&envId=2025-02-21
 */
public class LeetCode2209 {

    public static void main(String[] args) {
        LeetCode2209 obj = new LeetCode2209();
        obj.minimumWhiteTiles("10110101", 2, 2);
    }

    static final int INF = 0x3f3f3f3f;

    public int minimumWhiteTiles2(String floor, int numCarpets, int carpetLen) {
        int length = floor.length();
        int[][] dp = new int[length + 1][numCarpets + 1];
        // 初始化
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= numCarpets; j++) {
                dp[i][j] = INF;
            }
        }
        // 初始化 第0个砖头 以及 放置0个毯子
        for (int i = 0; i <= numCarpets; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= length; i++) {
            dp[i][0] = dp[i - 1][0] + (floor.charAt(i - 1) == '1' ? 1 : 0);
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= numCarpets; j++) {
                dp[i][j] = dp[i - 1][j] + (floor.charAt(i - 1) == '1' ? 1 : 0);
                dp[i][j] = Math.min(dp[i][j], dp[Math.max(0, i -carpetLen)][j-1]);
            }
        }
        return dp[length][numCarpets];
    }


    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        // 我们定义d[i][j]表示在前i个砖块上使用了j个地毯后，最少有多少未被覆盖的白色砖块
        int[][] d = new int[n + 1][numCarpets + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= numCarpets; j++) {
                d[i][j] = INF;
            }
        }
        for (int j = 0; j <= numCarpets; j++) {
            d[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            d[i][0] = d[i - 1][0] + (floor.charAt(i - 1) == '1' ? 1 : 0);
        }
         for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= numCarpets; j++) {
                // 不放置地毯时的数量
                d[i][j] = d[i - 1][j] + (floor.charAt(i - 1) == '1' ? 1 : 0);
                // 跟 放置地毯时的数量 取最小值
                d[i][j] = Math.min(d[i][j], d[Math.max(0, i - carpetLen)][j - 1]);
            }
        }
        return d[n][numCarpets];
    }

}
