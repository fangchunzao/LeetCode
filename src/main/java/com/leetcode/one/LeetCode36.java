package com.leetcode.one;

import java.util.HashSet;
import java.util.Set;

/**
 *  36. 有效的数独
 *
 *  判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 判断9x9二维数组行列是否存在相同
 * 将9x9二维数组分成9块3x3 判断每一块是否存在相同
 */
public class LeetCode36 {

    public static void main(String[] args) {
        char[][] a = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'3','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','2','.','.','8','.','.','7','9'},
        };
//        System.out.println(isValidArray2(new char[]{'5','3','1','2','7','.','3','.','.'}));
        System.out.println(isValidSudoku(a));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        char[] array = new char[9];
        char[] colArray;
        // 判断行 和 列
        for (int r = 0; r < board.length; r++) {
            array = board[r];
            // 判断行
            if (isValidArray2(array)) return false;
            colArray = new char[9];  // 列数组
            for (int c = 0; c < board[r].length; c++) {
                colArray[c] = board[c][r];
                // 判断块
                if (r % 3 == 0 && c % 3 == 0) { // 当 行 或者 列满足条件  生成一个块
                    if(isValidBlock(board,r,c)) return false;
                }
            }
             // 判断列
            if (isValidArray2(colArray)) return false;
        }
        // 判断列
        /*
        for (int r = 0; r < board.length; r++) {
            array = new char[9];
            for (int c = 0; c < board[r].length; c++) {
                colArray[c] = board[c][r];
            }
            if (isValidArray(colArray)) return false;
        }*/
        // 判断块

        return true;
    }

    /**
     * 判断数组中是否存在相同
     * @param array
     * @return boolean true 存在重复 false 不存在
     */
    public static boolean isValidArray(char[] array) {
        // 去掉 数组中的 "."
        Set<Character> set = new HashSet<>();
        int count = 0;// 数组中数字个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '.') {
                count++;
                set.add(array[i]);
            }
        }
        return !(set.size() == count);
    }

    /**
     * 标记法判断数组中是否存在相同
     * @param array
     * @return boolean true 存在重复 false 不存在
     */
    public static boolean isValidArray2(char[] array) {
        int[] arrayFlag = new int[9];

        for (int i = 0; i < array.length; i++) {
            if (array[i] != '.') {
                if (arrayFlag[array[i] - '1'] == 1) {
                    return true;
                } else {
                    arrayFlag[array[i] - '1'] = 1;
                }
            }
        }
        return false;
    }
    /**
     * 判断每一个3x3 块中是否存在相同数字
     * @param
     * @return boolean true 存在重复 false 不存在
     */
    public static boolean isValidBlock(char[][] board, int row, int col) {
        char[] array = new char[9];
        int index = 0;
        for (int r = row; r < row + 3; r++) {
            for(int c = col; c < col + 3; c++){
                array[index++] = board[r][c];
            }
        }
        return isValidArray2(array);
    }

}
