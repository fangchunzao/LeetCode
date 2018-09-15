package com.leetcode.algorithm.junior.array;

/**
 * @Auther: FCZ
 * @Description: 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * @Date: 2018/8/21 16:56
 */
public class Array11 {

    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
            for (int k = i, d = j; k < j; k++, d--) {
                int t = matrix[i][k];
                matrix[i][k] = matrix[d][i];
                matrix[d][i] = matrix[j][d];
                matrix[j][d] = matrix[k][j];
                matrix[k][j] = t;
            }
        }
    }
}
