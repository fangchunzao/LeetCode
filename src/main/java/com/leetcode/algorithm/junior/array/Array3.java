package com.leetcode.algorithm.junior.array;

import java.util.Arrays;

/**
 *  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  输入: [1,2,3,4,5,6,7] 和 k = 3
 *  输出: [5,6,7,1,2,3,4]
 */
public class Array3 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {-1,-100,3,99};
        rotate(b,2);
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length == 0) return;
        for (int j = 0; j < k; j++) {
            int prev = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = prev;
                prev = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
