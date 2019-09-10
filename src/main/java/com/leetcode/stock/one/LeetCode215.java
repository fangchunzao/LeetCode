package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/10 15:51
 **/
public class LeetCode215 {

    public static void main(String[] args) {
        LeetCode215 obj = new LeetCode215();
        System.out.println(obj.findKthLargest(new int[]{}, 0));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                assert index > target;
                right = index - 1;
            }
        }
    }

    /**
     * 在 nums 数组的 [left, right] 部分执行 partition 操作，返回 nums[i] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的语义
     * 1、(left, k] < nums[left]
     * 2、(k, i] >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 最后这一步不要忘记了
        swap(nums, j, left);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        // 转换转换一下 第target小的数
        int target = nums.length - k;

        while (true) {
            int index = 0;
            if (index == target) {
                return nums[index];
            } else if (index > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
    }

    public int partition1(int[] nums, int left, int right) {
        int firstNum = nums[left];
        int firstIndex = left;

        for (int i = left + 1; i < right; i++) {
            if (nums[i] < firstNum) {
                firstIndex++;
                swap(nums, i, firstIndex);
            }
        }

        swap(nums, firstIndex, left);
        return firstIndex;
    }


}
