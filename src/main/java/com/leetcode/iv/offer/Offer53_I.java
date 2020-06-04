package com.leetcode.iv.offer;

/**
 * 面试题53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer53_I {

    public static void main(String[] args) {

    }

    // 有序数组 采用二分查找
    public int search(int[] nums, int target) {
        // 查询出target最后的位置 - （target - 1）最后的位置 就是个数
        return binarySearch(nums, target) - binarySearch(nums, target - 1);
    }

    public int binarySearch(int[] nums, int tar) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // target数字会出现多次 因此要找到最左侧
            if (nums[mid] <= tar)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    // 暴力
    public int search1(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] == target)
               count++;
        }
        return count;
    }




}
