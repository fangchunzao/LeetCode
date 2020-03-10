package com.leetcode.iv.offer;

import java.util.Arrays;

/**
 * 面试题29. 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer29 {

    public static void main(String[] args) {
        Offer29 obj = new Offer29();
        System.out.println(Arrays.toString(obj.spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        })));

    }

    // 从左到右 从上到下 从右到左 从下到上 依次遍历
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }

        int[] result = new int[matrix.length * matrix[0].length];
        int left = 0, right = matrix[0].length - 1,
                top = 0, bottom = matrix.length - 1;
        int index = 0;
        while (true) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            if (++top > bottom)
                break;

            for(int i = top; i <= bottom; i++)
                result[index++] = matrix[i][right];

            if (--right < left) break;

            for(int i = right; i >= left; i--)
                result[index++] = matrix[bottom][i];

            if (--bottom < top) break;

            for (int i = bottom; i >= top; i--)
                result[index++] = matrix[i][left];

            if (++left > right) break;
        }
        return result;
    }


}
