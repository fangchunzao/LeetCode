package com.leetcode.iv.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题03. 数组中重复的数字

 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 *
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-07-02 复习
 */
public class Offer3 {

    // 遍历数组 hash表
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n))
                return n;
            set.add(n);
        }
        return -1;
    }

    // 根据题意 都是数字 找出重复的
    // 因此可以从头扫描数组 遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换
    // 如果置换前发现 该位置元素与当前元素相同 即为重复元素
    public int findRepeatNumber1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

}
