package com.leetcode.stock.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FangChunZao
 * @Description: 两数之和
 * @date 2018/7/18
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class LeetCode1 {

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        int[] result = twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = true;
        for (int i = 0; i < nums.length && flag; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    flag = false;
                    break;
                }
            }
        }
        return result;
    }
    // 最优解 hash遍历
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
