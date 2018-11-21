package com.leetcode.algorithm.junior.array;

/**
 * @author FCZ
 * @since 2018/11/21 11:06
 */
public class Array16 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen(7,nums));
    }

    // O(N) 时间复杂度
    public static int minSubArrayLen(int s, int[] nums) {
        int head = 0, tail = 0, sum = 0, min = Integer.MAX_VALUE;
        while (tail < nums.length) {
            sum += nums[tail];
            tail++;
            while (sum >= s) {
                min = Math.min(min, tail - head);
                sum -= nums[head];
                head++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static int minSubArrayLen1(int s, int[] nums) {
        int result = nums.length + 1;
        int total = 0;
        int head = 0,tail = 0;
        while (head < nums.length) {
            if (tail < nums.length  && total < s) {
                total += nums[tail++];
            } else {
                total -= nums[head];
                head++;
            }
            if (total >= s) {
                result = Math.min(result,tail - head);
            }
        }
       if (result == nums.length + 1) {
           return 0;
       }

/*        for (int i = 0; i < nums.length;) {
            int sum = 0;
            int arrCount = 0;
            while (i < nums.length && sum < s) {
                sum += nums[i++];
                arrCount++;
            }
            result = result > arrCount ? arrCount : result;
        }*/
        return result;
    }
}
