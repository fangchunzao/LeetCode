package com.leetcode.stock.one;

/**
 * Description: 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCode4 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {2,3,4,5,6,7};
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }

    //    作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            // 交换位置
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int N = nums1.length + nums2.length;
        if (N % 2 == 1)
            return findKth(nums1, 0, nums2, 0, N / 2 + 1); // 第二个数组第一位
        else
            return (findKth(nums1, 0, nums2, 0, N / 2 + 1) + findKth(nums1, 0, nums2, 0, N / 2)) / 2.0;
    }

    /**
     *  返回第k大的元素，从1开始。
     * @param a 数组a
     * @param alo 数组a 开始位置
     * @param b 数组b
     * @param blo 数组b 开始位置
     * @param k 每次分割的大小
     *
     * 如果数组a的中位数小于数组b的中位数，那么整体的中位数只可能出现在a的右区间加上b的左区间之中
     * 如果数组a的中位数大于等于数组b的中位数，那么整体的中位数只可能出现在a的左区间加上b的右区间之中。
     */
    private static int findKth(int[] a, int alo, int[] b, int blo, int k) {
        // a数组为空时，返回b数组第k个元素
        // k从1开始
        // alo,blo是第一个元素
        if (alo >= a.length)
            return b[blo + k - 1];
        // b数组为空时，返回a数组第k个元素
        if (blo >= b.length)
            return a[alo + k - 1];
        // 当k==1时，返回a[alo]、b[alo]中小的那个
        if (k == 1)
            return Math.min(a[alo], b[blo]);
        // i表示mid到lo之间的差值
        int i = k / 2 - 1;
        int aMid = Integer.MAX_VALUE;
        int bMid = Integer.MAX_VALUE;
        // lo+i正好为中位数下标位置
        if (alo + i < a.length)
            aMid = a[alo + i];
        if (blo + i < b.length)
            bMid = b[blo + i];
        if (aMid < bMid)
            // 在amid之前，包括amid，不可能存在中位数，跳过查找（删除），
            // alo到amid（包括）之间有i+1个数字
            // 去掉i+1个数字，原来第k大，变成第k-（i+1）大
            return findKth(a, alo + i + 1, b, blo, k - i - 1);
        else
            return findKth(a, alo, b, blo + i + 1, k - i - 1);
    }

}
