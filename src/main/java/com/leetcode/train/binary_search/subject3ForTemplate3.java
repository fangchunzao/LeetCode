package com.leetcode.train.binary_search;

/**
 * @Description: 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 */
public class subject3ForTemplate3 {

    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (left == mid) {
                return nums[left] > nums[right] ? left : right;
            }
            if (nums[mid] < nums[mid + 1]) { //右侧存在峰值
                left = mid;
            } else { // 左侧存在峰值
                right = mid;
            }
        }
        return -1;
    }

}
