package com.leetcode.iv.dic;

/**
 * @author fcz
 * @description 面试题 01.07. 旋转矩阵
 *
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *  
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [   00 01    03
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10], 13
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020-04-07 15:28
 **/
public class IV01_07 {

    public static void main(String[] args) {
        IV01_07 obj = new IV01_07();
        obj.rotate(new int[][]{
                { 5, 1, 9,11,1},
                { 2, 4, 8,10,1},
                {13, 3, 6, 7,1},
                {15,14,12,16,1},
        });
    }

    // 反转大法
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        // 先以对角线（左下-右上）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    // 太麻烦了
    public void rotate(int[][] matrix) {

        int length = matrix.length - 1;
        for (int level = 0; level < matrix.length / 2; level++) {
            for (int i = level; i < matrix[0].length - 1 - level; i++) {
                // 从左往右 每一个元素放到对应的位置上
                int pre = matrix[level][i];
                int next = matrix[i][length - level];
                matrix[i][length - level] = pre;
                //
                pre = next;
                next = matrix[length - level][length - i];
                matrix[length - level][length - i] = pre;

                pre = next;
                next = matrix[length - i][level];
                matrix[length - i][level] = pre;

                pre = next;
                matrix[level][i] = pre;
            }
        }
    }




}
