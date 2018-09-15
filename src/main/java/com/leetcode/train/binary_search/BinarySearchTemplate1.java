package com.leetcode.train.binary_search;

/**
 * @Description:  二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 */
public class BinarySearchTemplate1 {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums,5));
    }

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return -1;
    }

}
