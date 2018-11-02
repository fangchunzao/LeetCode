package com.leetcode.train.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FCZ
 * @since 2018/10/31 09:41
 *  螺旋矩阵
 *  给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class TwoArray {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3 },
                {4, 5, 6 },
                {7, 8, 9 },
                {6, 4, 5 },
        };
        System.out.println(spiralOrder(a));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 计算环数 最小的行列 除以2
        int ringCount = m > n ? (n + 1) / 2 : (m + 1) / 2;
        // 通过环数 遍历
        for (int i = 0; i < ringCount; i++, m -= 2, n -= 2) {
            // 环上
            for (int col = i; col < i + n; col++) {
                result.add(matrix[i][col]);
            }
            // 环右
            for (int row = i + 1; row <= i + m -1; row++) {
                result.add(matrix[row][i + n - 1]);
            }
            //最后一环为一行或一列，则在上面两步之后已经全部输出，直接退出
            if(m == 1 || n == 1)
                break;
            // 环下
            for (int col = i + n - 2; col >= i ; col--) {
                result.add(matrix[i + m - 1][col]);
            }
            // 环左
            for (int row = i + m - 2; row > i ; row--) {
                result.add(matrix[row][i]);
            }
        }
        return result;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length ==0){
            return res;
        }
        int numi = matrix.length;
        int numj = matrix[0].length;
        //环数
        int loop = numi > numj ? (numj + 1) / 2 : (numi + 1) / 2;

        for(int i = 0; i < loop; i++, numi -= 2,numj -= 2){
            // 按照环数遍历 遍历一圈 减少2行2列
            for(int col = i;col < i + numj; col++){
                res.add(matrix[i][col]);
            }
            for(int row = i + 1; row < i + numi; row++){
                res.add(matrix[row][i+numj-1]); // i+numj-1 每一环 的最后一位
            }
            //最后一环为一行或一列，则在上面两步之后已经全部输出，直接退出即可
            if(numi ==1||numj==1)
                break;

            for(int col = i + numj-2; col >= i; col--){
                res.add(matrix[i+numi-1][col]);
            }
            for(int row = i+numi -2;row>i;row--){
                res.add(matrix[row][i]);
            }
        }
        return res;
    }

}
