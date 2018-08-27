package com.leetcode.junior.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  两数之和
 *
 *  给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Array9 {

    public static void main(String[] args) {
        int[] a1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(a1, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (map.containsKey(v) && i != map.get(v)) {
                result[0] = i;
                result[1] = map.get(v);
                return result;
            }
        }
        return result;
    }
}
