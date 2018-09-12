package com.leetcode.stock.one;

/**
 *
 */
public class LeetCode35 {

    public static void main(String[] args) {
//        System.out.println(searchInsert(new int[]{2,4,5,6,10,12,18},19));
        System.out.println(searchInsert(null,2));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null) return 0;
        // 使用二分查找
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
