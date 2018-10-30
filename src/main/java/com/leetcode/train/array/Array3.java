package com.leetcode.train.array;

/**
 * @author FCZ
 * @since 2018/10/30 16:01
 */
public class Array3 {

    public static void main(String[] args) {
        int a[] = {3, 6, 1, 0};
        System.out.println(dominantIndex(a));
    }

    /**
     * 找出最大的两个值 判断最大的是 第二大 的两倍
     * @param nums
     * @return
     */
    public int dominantIndex1(int[] nums) {
        int max1 = 0,
                max2 = 0,
                index = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                index = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max1 >= max2 * 2 ? index : -1;

    }

    public static int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) maxIndex = i;
        }
        for(int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[maxIndex] < nums[i] * 2) {
                maxIndex = -1; break;
            }

        }
        return maxIndex;

    }

}
