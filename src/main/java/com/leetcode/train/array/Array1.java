package com.leetcode.train.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author FCZ
 * @since 2018/10/30 10:19
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *  00 01 10 20 11 02 12 21 22
 */
public class Array1 {

    public static void main(String[] args) {
        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(findDiagonalOrder(a)));
    }

    /**
    * description:
     * 建立坐标系，左上角为顶点（row,col）代替(0,0)确定要打印的每个点的坐标，每个点移动时有两个方向，右上或左下，碰到边界改变方向
     *
     * @param matrix:
    * @author FCZ
    * @since 2018-10-30
    */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] order = new int[m * n];

        int row = 0;
        int col = 0;
        //存储方向改变值，右上，或者左下
        int[][] dirs = {{-1, 1},{1, -1}};
        int k = 0;
        for (int i = 0; i < order.length; i++) {
            //将当前坐标赋值给新数组
            order[i] = matrix[row][col];
            //计算下一个点的坐标
            row += dirs[k][0];
            col += dirs[k][1];
            //根据边界条件，修正下一个点的坐标值.触碰边界，必然对方向取反
            //右上方向碰到边界
            if (col > n - 1) {
                col = n - 1;
                row += 2;
                //方向取反
                k = 1 - k;
            }
            if (row < 0) {
                row = 0;
                k = 1 - k;
            }
            //左下方向碰到边界
            if (row > m - 1) {
                row = m - 1;
                col += 2;
                k = 1 - k;
            }
            if (col < 0) {
                col = 0;
                k = 1 - k;
            }
        }
        return order;
    }
}
