package com.leetcode.iv.offer;

/**
 * 面试题53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-18 复习
 *
 */
public class Offer53_II {

    public static void main(String[] args) {
        Offer53_II obj = new Offer53_II();
        int[] nums = new int[]{0};
        System.out.println(obj.missingNumber213(nums));
        System.out.println(obj.missingNumber(nums));
    }


    public int missingNumber213(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left);
            if (nums[mid] <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 二分法
     * 因为有且一个数字不存在，假设位置为 X
     * 在X之前的数组 num[i] == i 之后的数组 num[i] != i
     * 因此可使用该条件作为二分
     */
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 注意是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;

    }

    // 暴力法
    public int missingNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return -1;
    }

}
