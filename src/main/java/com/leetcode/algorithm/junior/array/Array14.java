package com.leetcode.algorithm.junior.array;

import java.util.Arrays;

/**
 * @author FCZ
 * @since 2018/11/21 10:20
 * 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Array14 {

    public static void main(String[] args) {
        int[] nums = {3,3};
        System.out.println(removeElement(nums,3));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int tail = nums.length;
        int i = 0;
        while (i < tail) {
            if (nums[i] == val) {
                tail--;
                nums[i] = nums[tail];
            } else {
                i++;
            }
        }
        return tail;
    }

    public int removeElement2(int[] nums, int val) {
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
