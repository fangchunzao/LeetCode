package com.leetcode.algorithm.junior.array;

import java.util.Arrays;

/**
 *  189. 轮转数组
 *  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  输入: [1,2,3,4,5,6,7] 和 k = 3
 *  输出: [5,6,7,1,2,3,4]
 */
public class Array3 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {-1,-100,3,99};
        rotate2(a,3);
    }

    // 暴力方法
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

    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] cpNum = Arrays.copyOf(nums, len);
        for (int i = 0; i < len; i++) {
            int pos = (i + k) % len;
            nums[pos] = cpNum[i];
        }
    }

    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
