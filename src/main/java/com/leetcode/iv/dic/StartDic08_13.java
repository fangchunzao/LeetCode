package com.leetcode.iv.dic;

import java.util.Arrays;

/**
 * description 面试题 08.13. 堆箱子
 *
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。
 * 实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 *
 * 输入使用数组[wi, di, hi]表示每个箱子。
 *
 * 示例1:
 *
 *  输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 *  输出：6
 * 示例2:
 *
 *  输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 *  输出：10
 * 提示:
 *
 * 箱子的数目不大于3000个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pile-box-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-30 20:13:28
 */
public class StartDic08_13 {

    // 动态规划
    public int pileBox(int[][] box) {
        if (box == null || box.length == 0)
            return 0;
        // 对数组进行排序  [wi, di, hi] [升序, 降序, 降序]
        Arrays.sort(box , (a,b) -> a[0] == b[0] ? a[1] == b[1] ? b[2] - a[2] : b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[box.length];
        dp[0] = box[0][2];
        int res = dp[0];
        for (int i = 1; i < box.length; i++) {
            int maxValue = 0;
            // 数组按照wi  当前的箱子 + 之前的箱子  遍历找出最大值
            // di, hi 为降序 当wi相同时 可以不用判断wi 减少判断次数 提升速度
            for (int j = 0; j < i; j++) {
                if (box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }
            dp[i] = maxValue + box[i][2];
            res = Math.max(dp[i], res);
        }
        return res;

    }


    // 回溯 超时
    public int pileBox1(int[][] box) {
        if (box == null || box.length == 0)
            return 0;
        pileBox(box, -1, new boolean[box.length], 0);
        return maxRes;
    }

    int maxRes = 0;
    public void pileBox(int[][] box, int row, boolean[] exist, int currMax) {

        for (int i = 0; i < box.length; i++) {
            if (exist[i])
                continue;
            int[] box2 = box[i];
            if (row == -1) {
                maxRes = Math.max(box2[2], maxRes);
                exist[i] = true;
                pileBox(box, i, exist, box2[2]);
                exist[i] = false;
                continue;
            }
            int[] box1 = box[row];
            if (box1[0] < box2[0] && box1[1] < box2[1] && box1[2] < box2[2]) {
                // 当前最大值
                int maxH = currMax + box2[2];
                maxRes = Math.max(maxH, maxRes);
                exist[i] = true;
                pileBox(box, i, exist, maxH);
                exist[i] = false;
            }
        }
    }

}
