package com.leetcode.top_interview150.array1;

/**
 * 55. 跳跃游戏
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class Array09 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return true;
        }
        int span = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < span) {
                span++;
                continue;
            }
            if (i == 0) {
                return true;
            }
            span = 1;
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        if (n <= 1) {return true;}

        int rightSpan = 0;
        for (int i = 0; i < n; i++) {
            if (rightSpan >= i) {
                rightSpan = Math.max(rightSpan, nums[i] + i);
                if (rightSpan >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


}
