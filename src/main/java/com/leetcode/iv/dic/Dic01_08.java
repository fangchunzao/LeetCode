package com.leetcode.iv.dic;

import java.util.HashSet;
import java.util.Set;

/**
 * description 面试题 01.08. 零矩阵
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-06-30 20:23:01
 */
public class Dic01_08 {

    // 使用第一行保存需要清空的列
    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int rowLength = matrix.length;
        int lineLength = matrix[0].length;
        boolean clearFirst = false;   // 是否需要清空第一行
        for (int i = 0; i < rowLength; i++) {
            boolean clearRow = false;
            for (int j = 0; j < lineLength; j++) {
                if (matrix[i][j] == 0) {
                    // 该行列需要清空 将列记录在第一行 行直接清空
                    if (i == 0)
                        // 第一行先不能清空 最后清空
                        clearFirst = true;
                    else
                        // 标识改行需要清空
                        clearRow = true;

                    matrix[0][j] = 0;
                }
            }
            // 清空行
            if (clearRow)
                matrix[i] = new int[lineLength];
        }
        // 根据第一行记录的列 清空列
        for (int i = 0; i < lineLength; i++) {
            if (matrix[0][i] == 0) {
                // 清空列
                for (int j = 1; j < rowLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (clearFirst)
            matrix[0] = new int[lineLength];

    }

    // 保存需要清空的行列 然后进行清空
    public static void setZeroes1(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int rowLength = matrix.length;
        int lineLength = matrix[0].length;
        // 记录需要清空的横纵坐标
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> lineSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    lineSet.add(j);
                }
            }
        }
        for (Integer row : rowSet) {
            matrix[row] = new int[lineLength];
        }
        for(Integer line : lineSet) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][line] = 0;
            }
        }
    }

}
