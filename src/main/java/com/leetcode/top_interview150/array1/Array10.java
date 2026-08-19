package com.leetcode.top_interview150.array1;

/**
 * 45. 跳跃游戏 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 *
 * 0 <= j <= nums[i] 且
 * i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 n - 1
 */
public class Array10 {

    public int jump(int[] nums) {

        int posi = nums.length - 1;
        int step = 0;
        while (posi > 0) {
            for (int i = 0; i < posi; i++) {
                if (i + nums[i] >= posi) {
                    posi = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        int end = 0;
        int span = 0;
        int step = 0;

        for (int i = 0; i < n - 1; i++) {
            span = Math.max(span, i + nums[i]);

            if (i == end) {
                step++;
                end = span;

            }
        }
        return step;
    }


}
