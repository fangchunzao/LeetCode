package com.leetcode.iv.dic;

/**
 * description 面试题 16.17. 连续数列
 *
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-08-12 10:15
 */
public class Dic16_17 {


    public int maxSubArray(int[] nums) {
        int maxRes = Integer.MIN_VALUE;
        int sum = 0;
        for(int n : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += n;
            maxRes = Math.max(maxRes, sum);
        }
        return maxRes;
    }

    // 分治
    public int maxSubArray1(int[] nums) {
        if(nums.length == 0) return Integer.MIN_VALUE;

        return maxSubArray(nums, 0, nums.length - 1);
    }

    public int maxSubArray(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];

        int mid = (left + right) / 2;
        // 1. 最大数列和在左边
        int leftRes = maxSubArray(nums, left, mid);
        // 2. 最大数列和在右边
        int rightRes = maxSubArray(nums, mid + 1, right);
        // 3. 最大数列和在中间
        // 分别求出左右两边的最大 相加起来
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }
        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }
        return Math.max(Math.max(leftRes, rightRes), leftMax + rightMax);

    }

}
