package com.leetcode.iv.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题39. 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 */
public class Offer39 {

    // 投票计数
    // 1.初始化计数器cnt = 0； 返回目标值n = nums[0]; 表示从此时开始计算投票。
    //
    // 2.遍历数组，如果接下来出现的数字与n相同，cnt加1。如果不同，cnt减1。
    //
    // 3.如果cnt == 0，表示之前出现的所有数字中n之间都是可以凑成不同的数对，一起抵消，直接遍历下一个数。重复次数大于n/2的数还会在后面出现。遍历完数组，满足条件的 n 其 cnt 必定>0。
    public int majorityElement(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0)
                res = nums[i];
            sum += res == nums[i] ? 1:-1;
        }
        return res;
    }

    // 哈希表
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n,1);
        }
        int result = Integer.MIN_VALUE;
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > result) {
                result = entry.getValue();
                count = entry.getKey();
            }
        }
        return count;
    }

}
