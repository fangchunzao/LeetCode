package com.leetcode.stock.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/13 11:11
 **/
public class LeetCode169 {

    public static void main(String[] args) {
        int a[] = {1,1,1,2,2,2,2,2};

        System.out.println(majorityElement0(a));
    }

    // 递归实现
    public static int majorityElement0(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 还可以使用Hash表 实现比较简单

    // 先排序 判断每个数据出现的次数 (笨方法) 当排序完成后，中间的数字就是众数
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1, // 总次数
                preNum = nums[0],  // 上一个数字
                numCount = 1,      // 当前数字出现的次数
                result = nums[0];  // 结果数字
        for (int i = 1; i < nums.length; i++) {
            if (preNum != nums[i]) {
                // 如果数字不同 需要重新计数
                preNum = nums[i];
                numCount = 1;
            } else {
                // 当前数字出现的次数+1
                numCount++;
            }
            // 如果当前数字出现的次数最大 作为结果
            if (numCount > count) {
                count = numCount;
                result = nums[i];
            }
        }
        return result;
    }


    // 使用分治算法
    // 判断出左侧众数 和 右侧的众数 然后判断谁大
    public static int majorityElement1(int[] nums) {
        return majorityElement1(nums, 0, nums.length-1);
    }

    private static int majorityElement1(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        if (lo == hi) {
            return nums[lo];
        }

        // 从中点分割为两个数组
        int mid = (hi-lo)/2 + lo;
        int left = majorityElement1(nums, lo, mid);
        int right = majorityElement1(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // 计算左右数组的个数
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }


    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
