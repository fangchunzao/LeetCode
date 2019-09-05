package com.leetcode.stock.one;

/**
 * 334. 递增的三元子序列
 *
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/5 09:25
 **/
public class LeetCode334 {

    // [2,1,5,0,4,6]

    public static void main(String[] args) {
        LeetCode334 obj = new LeetCode334();

        int[] nums = {5,4,3,2,1};
        System.out.println(obj.increasingTriplet(nums));
    }

    // 暴力解法 将最小的 和 次小值 存起来 依次判断
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int num : nums) {
            if (num <= first)
                first = num;
            else if (num <= second)
                second = num;
            else return true;
        }
        return false;
    }


}
