package com.leetcode.junior.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
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
