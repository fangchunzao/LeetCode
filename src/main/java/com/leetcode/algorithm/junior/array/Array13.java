package com.leetcode.algorithm.junior.array;

import java.util.Arrays;

/**
 * @author FCZ
 * @since 2018/11/21 10:02
 *
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
说明:
返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 */
public class Array13 {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers,9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (target == numbers[left] + numbers[right]){
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            if (target > numbers[left] + numbers[right]){
                left++;
                continue;
            }
            right--;
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i+1;
                    result[1] = j+1;
                }
            }
        }
        return result;
    }

}
