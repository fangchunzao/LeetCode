package com.leetcode.iv.offer;

/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-09 复习
 */
public class Offer21 {

    // 双指针
    public int[] exchange(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            while (nums[low] % 2 == 0 && low < high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high--] = temp;
            }
            low++;
        }
        return nums;
    }

}
