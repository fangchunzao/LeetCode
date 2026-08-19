package com.leetcode.top_interview150.array1;

/**
 * 169. 多数元素
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * 输入保证数组中一定有一个多数元素。
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class Array05 {


    public int majorityElement(int[] nums) {

        int ct = 0;
        int star = 0;
        for(int n : nums) {
            if (ct == 0) {
                star = n;
            }
            ct += star == n ? 1 : -1;
        }
        return star;
    }

}
