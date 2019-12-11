package com.leetcode.stock.one;

/**
 *
 * 31. 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author fcz
 * @description
 * @date 2019-12-11 17:10
 **/
public class LeetCode31 {
    // 这道题看官方的解析很难懂啊
    // 简单来说 就是找到恰好比当前数组大一点的数组
    // 所以采用的思路先找到目标数字
    // 整个数组的规则 从右往左 应该是 num[i - 1] > num[i]
    // 当不符合条件时 说明找到了那个数字
    // 然后再次从右到左找 直到比目标数字大 即置换数字就行
    // 为了满足条件 指定数字右侧数组需要进行一次旋转

    public static void main(String[] args) {
        LeetCode31 obj = new LeetCode31();
        obj.nextPermutation(new int[]{1,5,8,4,7,6,5,3,1});
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
