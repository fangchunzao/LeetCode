package com.leetcode.stock.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/13 10:43
 **/
public class LeetCode136 {

    public static void main(String[] args) {
        int[] a = {4,1,2,1,2};
        System.out.println(singleNumber3(a));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], true);
            } else {
                map.put(nums[i], false);
            }
        }
        for (Map.Entry<Integer, Boolean> entry: map.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 速度更快
    public static int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int i;
        for (i = 1; i < nums.length; i = i + 2) {
            if (!(nums[i] == nums[i - 1])) {
                return nums[i - 1];
            }
        }
        return i == nums.length - 1 ? 0 : nums[nums.length - 1];
    }

    // 异或运算 最优解
    public static int singleNumber3(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }




}
