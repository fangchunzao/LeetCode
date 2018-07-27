package com.leetcode.one;

/**
 * 移除元素
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode27 {

    public static void main(String[] args) {
        int[] a = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(new int[5],2));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null) return 0;

        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                n--;
                nums[i] = nums[n];
            } else {
                i++;
            }
        }
        return n;
    }
}
