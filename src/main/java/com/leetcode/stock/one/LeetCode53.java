package com.leetcode.stock.one;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @description
 * @date 2020-01-03 15:00
 **/
public class LeetCode53 {

    public static void main(String[] args) {
        LeetCode53 obj = new LeetCode53();
        System.out.println(obj.maxSubArray2(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    // 贪心算法
    // 相加 判断当前最大 和 总体最大的 值
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    // 动态规划
    // 使用前一项保存当前的最大值
    // 如果前一项是负的 就是个累赘 不进行累加
    // 如果前一项是正的 进行累加
    // 判断当前最大值 与 总体最大值
    public int maxSubArray2(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }


}
