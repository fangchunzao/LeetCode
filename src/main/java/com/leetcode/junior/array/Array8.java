package com.leetcode.junior.array;

import java.util.Arrays;

/**
 *  移动零
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Array8 {

    public static void main(String[] args) {
        int[] a1 = {0,1,0,3,12};
        moveZeroes(a1);
        System.out.println(Arrays.toString(a1));
    }

    public static void moveZeroes(int[] nums) {
        int lastIndex = nums.length - 1;
        int curIndex = nums.length - 1;
        int count;

        while (curIndex >= 0) {
            if (nums[curIndex] == 0) {
                count = lastIndex - curIndex;
                for (int i = 0; i < count; i++) {
                    nums[curIndex + i] = nums[curIndex + i + 1];
                }
                nums[lastIndex] = 0;
                lastIndex--;
            }
            curIndex--;
        }
    }
}
