package com.leetcode.algorithm.junior.array;

/**
 *  给定一个整数数组，判断是否存在重复元素。
 *
 *  如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class Array4 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,1};
        System.out.println(containsDuplicate(a));
    }

    public static boolean containsDuplicate(int[] nums) {
        // 采用暴力破解 可以使用Set 和Arrays.sort()方法进行操作
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
