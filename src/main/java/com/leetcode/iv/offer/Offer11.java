package com.leetcode.iv.offer;

import java.util.Arrays;

/**
 * 面试题11. 旋转数组的最小数字
 * 153. 寻找旋转排序数组中的最小值
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer11 {

    public static void main(String[] args) {
        Offer11 obj = new Offer11();
//        System.out.println(obj.minArray(new int[] {1,3,5}));
        System.out.println(Arrays.toString(obj.evenOddBit(50)));

    }
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                if (i % 2 == 0) {
                    res[0]++;
                } else {
                    res[1]++;
                }
            }
        }
        return res;
    }

    /**
     * 153. 寻找旋转排序数组中的最小值
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     *
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     * 示例 2：
     *
     * 输入：nums = [4,5,6,7,0,1,2]
     * 输出：0
     * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
     * 示例 3：
     *
     * 输入：nums = [11,13,15,17]
     * 输出：11
     * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
     *
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 中的所有整数 互不相同
     * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     *
     * @since https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
     *
     * @param nums
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        return nums[start];
    }

    // 二分查找 需要与右边对比
    // 如果与左边对比 [1,2,3,4,5]   [3,4,5,1,2]  中间的值与左侧对比 最小值都在左侧
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            // [3,3,1,3]
            else j--;
        }
        return numbers[i];
    }


}
