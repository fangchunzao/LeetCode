package com.leetcode.train.queue_stack.dfs_search;

/**
 * @author FCZ
 * @since 2018/10/29 17:11
 */
public class DFS3 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        int[] arr = new int[1];
        dfs(nums, S, arr, 0, 0);
        return arr[0];
    }

    private static void dfs(int[] nums, int S, int[] arr, int sum, int start) {
        if (start == nums.length) {
            if (sum == S) {
                arr[0]++;
            }
            return;
        }
        dfs(nums, S, arr, sum - nums[start], start + 1);
        dfs(nums, S, arr, sum + nums[start], start + 1);
    }
}
