package com.leetcode.train.binary_search;

/**
 * @Description: 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class subject3ForTemplate1 {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,0,1,2};
        System.out.println(search(nums, 8));
        System.out.println(searchT(nums, 8));
    }

    /**
     *  对于数组 [0,1,2,4,5,6,7] 共有其中7中旋转方法
     * 0　　1　　2　　4　　5　　6　　7
     * 7　　0　　1　　2　　4　　5　　6
     * 6　　7　　0　  1　　2　　4　　5
     * 5　　6　　7　　0　　1　　2　　4
     * 4　　5　　6　　7　　0　　1　　2
     * 2　　4　　5　　6　　7　　0　　1
     * 1　　2　　4　　5　　6　　7　　0
     * 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            // 判断左边是有序 还是右边是有序
            else if (nums[mid] < nums[right]) {  // 右边是有序
                // 判断target在有序中还是无序中
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;  // 数组右侧是有序序列，存在有序序列中
                }
                else right = mid - 1; // 数组右侧是有序序列，不存在有序序列中
            } else { // 左边是有序
                // 判断target在有序中还是无序中
                if (nums[left] <= target && nums[mid] > target){
                    right = mid - 1;  // 数组左侧是有序序列，存在有序序列中
                }
                else left = mid + 1;  // 数组左侧是有序序列，不存在有序序列中
            }
        }
        return -1;
    }

    public static int searchT(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums [mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                if (nums[right] >= target && nums[mid] < target) {  // 右侧有序
                    left = mid + 1;
                } else  {
                    right = mid - 1;  // 右侧无序
                }
            } else {
                if(nums[left] <= target && nums[mid] > target) {   // 左侧有序
                    right = mid - 1;
                } else {
                    left = left + 1;
                }
            }
        }
        return -1;
    }
}
