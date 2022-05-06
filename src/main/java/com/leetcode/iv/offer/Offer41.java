package com.leetcode.iv.offer;

/**
 * 面试题42. 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 *
 * 提示：
 *
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-18 复习
 *
 */
public class Offer41 {

    public static void main(String[] args) {

    }

    // 使用两个数字进行记录
    // sum 进行累加 如果当前数字大于sum， sum重置 （前面数字就没有了意义，只会让当前累加的和变小）
    // maxSum 存放最大子数组
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp > sum && sum < 0) {
                sum = temp;
            } else {
                sum+=temp;
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    // 动态规划 贪心思想
    // 循环遍历 每一个位置i， 位置i就是当前的最大值
    public int maxSubArray1(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

}
