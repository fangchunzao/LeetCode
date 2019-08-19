package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/19 16:18
 **/
public class LeetCode88 {

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge1(num1, 3, num2, 3);
    }

    // 合并后排序
    //时间复杂度 : O((n + m)log(n + m))
    //空间复杂度 : O(1)
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < nums1.length && j < n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    // 双指针 从前往后
    // 时间复杂度 : O(n + m)
    // 空间复杂度 : O(m)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = nums1.clone();
        int p1 = 0,p2 = 0;  // 双指针
        int p = 0;
        // 判断有序数组元素的大小 依次放入num1中
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1Copy[p1] < nums2[p2]) ? nums1Copy[p1++] : nums2[p2++];
        // 当A数组到边界 而 B数组还没有到达边界时  需要将其他元素补充进来
        if (p1 < m)
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    // 双指针 从后往前
    // 时间复杂度 : O(n + m)
    // 空间复杂度 : O(1)
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        // 双指针
        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n - 1;

        // 从后往前 指针移动 逐次将大元素放入尾部
        while ((p1 >= 0) && (p2 >= 0))
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        // 当num2中前几位都是小元素时 指针p2无法前进到数组头 因此num2会有部分遗留元素
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }

}
