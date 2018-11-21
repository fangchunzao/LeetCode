package com.leetcode.algorithm.junior.array;

import java.util.Arrays;

/**
 * description: 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * 示例 1:
 * 输入: [1,4,3,2]
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * @author FCZ
 * @since 2018-11-20
 */
public class Array12 {

    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        System.out.println(arrayPairSum(arr));
    }

    public static int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        int minSum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            minSum += nums[i];
        }
        return minSum;
    }

}
