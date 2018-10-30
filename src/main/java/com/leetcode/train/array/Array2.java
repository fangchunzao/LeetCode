package com.leetcode.train.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FCZ
 * @since 2018/10/30 14:31
 */
public class Array2 {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex1(nums));
    }

    public static int pivotIndex1(int[] nums) {
        int sum = 0, // 数组综合
            leftnum = 0,  // 左侧和
            rightnum = 0;  // 右侧和
        for(int n : nums) { // 全部累加
            sum = sum + n;
        }
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                leftnum = 0;
            } else {
                leftnum = leftnum + nums[i-1];
            }
            rightnum = sum - leftnum - nums[i];  // 右侧的数 == 总和 - 左侧的数 - 当前值
            if(rightnum == leftnum) {
                return i;
            }
        }
        return -1;
    }

    public static int pivotIndex(int[] nums) {
        return test(nums, 0);
    }

    public static int test(int[] nums, int index) {
        if (index < 0 || index > nums.length - 1) {  // 到达边界  index 到了数组末尾 就已经需要结束了 [0,1,2] length = 3, 大于1 就结束了
            return -1;
        }
        int left = 0,right = 0;
        for (int i = 0; i < index; i++) {
            left += nums[i];
        }
        for (int i = index + 1; i < nums.length; i++) {
            right += nums[i];
        }

        if (left == right) {
            return index;
        } else {  // 左移
            return test(nums, index + 1);
        }
    }
}
