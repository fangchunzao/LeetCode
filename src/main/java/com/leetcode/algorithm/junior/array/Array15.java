package com.leetcode.algorithm.junior.array;

/**
 * @author FCZ
 * @since 2018/11/21 10:52
 *  最大连续1的个数
 *  给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 */
public class Array15 {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length;) {
            int count = 0;
            if (nums[i] == 0){
                i++;
                continue;
            }
            while (i < nums.length && nums[i] == 1) {
                i++;
                count++;
            }
            result = result > count ? result : count;
        }
        return result;
    }


}
