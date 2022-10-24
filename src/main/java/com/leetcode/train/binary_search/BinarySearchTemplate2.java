package com.leetcode.train.binary_search;

/**
 * @Auther: FCZ
 * @Description:
 * @Date: 2018/9/13 09:08
 */
public class BinarySearchTemplate2 {

    public static void main(String[] args) {
        BinarySearchTemplate2 obj = new BinarySearchTemplate2();
        int[] nums = new int[]{1,7,7,7,7};
        System.out.println(obj.binSearch(nums, 7));
    }

    // 可以寻找到目标元素 最靠近左侧的
    public int binSearch(int[] nums, int target) {
            if(nums == null || nums.length == 0)
                return -1;

            int left = 0, right = nums.length - 1;
            while(left < right){
                // Prevent (left + right) overflow
                int mid = left + (right - left) / 2;
                if(nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
    }

    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid; }
        }

        // Post-processing:
        // End Condition: left == right
        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }

}
