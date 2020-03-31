package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * @author fcz
 * @description 912. 排序数组
 * 给你一个整数数组 nums，将该数组升序排列。
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @date 2020-03-31 10:00
 **/
public class LeetCode912 {

    public static void main(String[] args) {
        LeetCode912 obj = new LeetCode912();
        System.out.println(Arrays.toString(obj.sortArray(new int[]{5,2,3,5,2,3,6,2,6,5})));
    }
    // TODO 需要添加别的排序算法 好多的
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 快速排序
    public void quickSort(int[] nums, int l, int h) {
        if (l >= h) return;
        int p = l, high = h;
        while (l < h) {
            while (l < h && nums[h] >= nums[p]) h--;

            while (l < h && nums[l] <= nums[p]) l++;
            if (l < h)
                swap(nums, l, h);
        }
        swap(nums, p, h);
        quickSort(nums, p, h - 1);
        quickSort(nums, h + 1, high);
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
