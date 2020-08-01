package com.leetcode.iv.dic;

/**
 * description 面试题 10.01. 合并排序的数组
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-08-01 15:12:30
 */
public class Dic10_01 {

    /**
     * 方法1. 将B填充到A的后面 然后排序
     * 方法2. 双指针 填充到辅助数组
     * 方法3. 逆向双指针
     */
    // 前俩方法实现简单 就实现以下第三种
    public void merge(int[] A, int m, int[] B, int n) {
        int maxLength = A.length - 1;
        while (m > 0 && n > 0) {
            // 从后往前 大的放在A的末尾
            if (A[m - 1] >= B[n - 1]) {
                A[maxLength--] = A[--m];
            } else {
                A[maxLength--] = A[--n];
            }
        }
        while (n > 0) {
            A[maxLength--] = A[--n];
        }
    }



}
