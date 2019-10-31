package com.leetcode.stock.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 324. 摆动排序 II
 *
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 *
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 *
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/10/31 10:56
 **/
public class LeetCode324 {
    public static void main(String[] args) {
        LeetCode324 obj = new LeetCode324();
        obj.wiggleSort1(new int[]{1,1,1,2,1,2,2});
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int splitSpot = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1 ;
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }
        for (int i = 1, j = splitSpot; j < nums.length - 1; i = i + 2, j++) {
            list.add(i, nums[j]);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = list.get(i);
        }
        int ss = 1;
    }

    public void wiggleSort1(int[] nums) {
        //排序
        Arrays.sort(nums);
        int len = nums.length, i = 0;
        // 分割成两个数组 大数组和小数组
        int[] smaller = new int[len % 2 == 0 ? len / 2 : (len / 2 + 1)], bigger = new int[len / 2];
        //复制
        // src:源数组；
        // srcPos:源数组要复制的起始位置；
        // dest:目的数组；
        // destPos:目的数组放置的起始位置；
        // length:复制的长度。
        System.arraycopy(nums,0,smaller,0,smaller.length);
        System.arraycopy(nums,smaller.length,bigger,0,bigger.length);
        // 大数组与小数组 穿插倒序取值
        for (; i < len / 2; i++) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
            nums[2 * i + 1]=bigger[bigger.length - 1 - i];
        }
        // 最后一位 奇数个的数组 需要填充最后一位
        if (len % 2 != 0) nums[2 * i]=smaller[smaller.length-1-i];
    }
}
