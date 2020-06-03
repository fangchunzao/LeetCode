package com.leetcode.iv.offer;

/**
 * description 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * [7,5] [7,6] [7,4] [5,4] [6,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since  2020-06-03 10:41
 **/
public class HardOffer51 {

    // 双层循环的暴力解法 超时


    /**
     * 归并排序
     * 归并排序实际上会把数组分成两个有序部分，我们不妨称其为左和右，
     * 归并排序的过程中会将左右两部分合并成一个有序的部分，对于每一个左右部分，
     * 我们分别计算其逆序数，然后全部加起来就是我们要求的逆序数
     */
    static int[] temp = null;  // 如果每次初始化 会超时
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int len = nums.length;
        temp = new int[len];
        return reversePairs(nums, 0, len - 1);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int reversePairs(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid);
        int rightPairs = reversePairs(nums, mid + 1, right);

        // 左侧全部小于右侧
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        // 计算交叉部分的逆序对
        int crossPairs = mergeAndCount(nums, left, mid, right);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     * 计算交叉其中的对数
     *
     * @param nums 原数组
     * @param left 左侧开始点
     * @param mid 分割点
     * @param right 右侧结束点
     * @return 逆数对数
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right) {
        int[] temp = new int[nums.length];
        // 复制数组
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int leftIndex = left;  // 左侧数组开始下标
        int rightIndex = mid + 1;  // 右侧数组中间下标

        int count = 0;   // 计算逆序对
        for (int k = left; k <= right; k++) {

            if (leftIndex == mid + 1) {
                // 左侧数组已经放完了 吧剩下的右侧数组都放进去
                nums[k] = temp[rightIndex];
                rightIndex++;
            } else if (rightIndex == right + 1) {
                // 与上相反
                nums[k] = temp[leftIndex];
                leftIndex++;
            } else if (temp[leftIndex] <= temp[rightIndex]) {
                // 将小的的数放进去
                nums[k] = temp[leftIndex];
                leftIndex++;
            } else {
                // 这种情况存在 【逆序对】
                nums[k] = temp[rightIndex];
                rightIndex++;
                // mid是左侧数组与右侧数组的分割点
                // i是左侧数组现在的位置
                // mid - i 计算出 在j位置 当前存在逆序对数
                // 结果+1 因为计算的是下标
                count += (mid - leftIndex + 1);
            }
        }
        return count;
    }

    public int reversePairs1(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] num, int left, int right) {
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        int leftCount = mergeSort(num, left, mid);
        int rightCount = mergeSort(num, mid + 1, right);

        if (num[mid] <= num[mid + 1]) {
            return leftCount + rightCount;
        }
        int mergeCount = mergeArrayAndCount(num, left, mid, right);
        return leftCount + rightCount + mergeCount;
    }

    public int mergeArrayAndCount(int[] num, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = num[i];
        }

        int leftIndex = left;
        int rightIndex = mid + 1;

        int count = 0;
        for (int i = left; i <= right; i++) {
            if (leftIndex == mid + 1) {
                num[i] = temp[rightIndex];
                rightIndex++;
            } else if (rightIndex == right + 1) {
                num[i] = temp[leftIndex];
                leftIndex++;
            } else if (temp[leftIndex] <= temp[rightIndex]) {
                num[i] = temp[leftIndex];
                leftIndex++;
            } else {
                num[i] = temp[rightIndex];
                rightIndex++;
                count += mid - leftIndex + 1;
            }
        }
        return count;
    }
}
