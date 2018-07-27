package com.leetcode.one;

import java.util.HashSet;
import java.util.Set;

/**
 *
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
            if (isValidArray2(array)) return false;
            colArray = new char[9];
            for (int c = 0; c < board[r].length; c++) {
                colArray[c] = board[c][r];
            }
            if (isValidArray2(colArray)) return false;
        }
        // 判断列
        /* 傻逼LeetCode 我多写个循环就说我超时 影响我模块化代码
        for (int r = 0; r < board.length; r++) {
            array = new char[9];
            for (int c = 0; c < board[r].length; c++) {
                colArray[c] = board[c][r];
            }
            if (isValidArray(colArray)) return false;
        }*/
        // 判断块
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (r % 3 == 0 && c % 3 == 0) { // 当 行 或者 列满足条件  生成一个块
                    if(isValidBlock(board,r,c)) return false;
                }
            }
        }
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
     * 标记法判断
     * @param array
     * @return
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
