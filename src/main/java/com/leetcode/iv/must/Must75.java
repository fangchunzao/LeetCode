package com.leetcode.iv.must;

/**
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Must75 {

    public static void main(String[] args) {
        Must75 obj = new Must75();
        obj.sortColors(new int[]{1,0,0});
    }

    public void sortColors(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] == 0) {
                start++;
                continue;
            }
            if (nums[end] == 0) {
                swap(nums, start, end);
                start++;
            }
            end--;
        }
        end = nums.length - 1;
        while (start < end) {
            if (nums[start] == 1 || nums[start] == 0) {
                start++;
                continue;
            }
            if (nums[end] == 1) {
                swap(nums, start, end);
                start++;
            }
            end--;
        }
        int i = 0;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
