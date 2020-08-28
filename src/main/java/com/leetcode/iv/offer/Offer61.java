package com.leetcode.iv.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * description 面试题61. 扑克牌中的顺子
 *
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
 * A 不能视为 14。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-06-10 10:41
 *
 * @since 2020-08-24 复习
 **/
public class Offer61 {
    /**
     * 除了0，数组不能有重复的数字
     * 最大值和最小值的差小于5
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> exist = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if(exist.contains(num))
                return false;
            min = Math.min(min, num);
            max = Math.max(max, num);
            exist.add(num);
        }
        return max - min < 5;
    }

    /**
     * 1. 不能存在重复
     * 2. 最大值减去最小值 < 5
     */
    public boolean isStraight1(int[] nums) {
        Arrays.sort(nums); // 数组排序
        int joker = 0;
        for(int i = 0; i < 4; i++) {
            // 统计大小王数量 找出最小值的下标
            if(nums[i] == 0) joker++;
                // 若有重复，提前返回 false
            else if(nums[i] == nums[i + 1])
                return false;
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }


}
