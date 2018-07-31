package com.leetcode.junior.array;

import java.util.Arrays;

/**
 *  只出现一次的数字
 *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入: [2,2,1]
 * 输出: 1
 */
public class Array5 {

    public static void main(String[] args) {
        int a[] = {1,2,1};
        System.out.println(singleNumber(a));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i;
        for (i = 1; i < nums.length; i = i + 2) {
            if (!(nums[i] == nums[i - 1])) {
                return nums[i - 1];
            }
        }
        return i == nums.length - 1 ? 0 : nums[nums.length - 1];
    }
}
