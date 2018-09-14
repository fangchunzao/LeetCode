package com.leetcode.train.binary_search;

import java.util.Arrays;

/**
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 *
 *  给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *  你的算法时间复杂度必须是 O(log n) 级别。
 *  如果数组中不存在目标值，返回 [-1, -1]。
 *  示例 1:
 *  输入: nums = [5,7,7,8,8,10], target = 8
 *  输出: [3,4]
 *
 */
public class subject1ForTemplate3 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] nums2 = {1};
        System.out.println(Arrays.toString(searchRange(nums2,8)));
    }
    // 最初的思路是使用二分法找到目标值的其中一个下标，再根据该下标左右遍历得出初始下标和结束下标。
    public int[] searchRange1(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]==target){
                while(mid>=left && nums[mid]==target){
                    mid--;
                }
                result[0] = mid+1;
                mid = (left + right)/2;
                while(mid<=right && nums[mid]==target){
                    mid++;
                }
                result[1] = mid - 1;
                break;
            }else if (nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if (nums == null || nums.length == 0)
            return res;

        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                while (mid >= left && nums[mid] == target) {
                    mid--;
                }
                res[0] = mid + 1;
                mid = left + (right - left) / 2;
                while (mid <= right && nums[mid] == target) {
                    mid++;
                }
                res[1] = mid - 1;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

}
