package com.leetcode.iv.must;

import java.util.HashMap;
import java.util.Map;

/**
 * 79. 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Must79 {

    public static void main(String[] args) {
        Must79 obj = new Must79();
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(obj.exist(board, "BDF"));
    }

    public boolean exist(char[][] board, String word) {

        char[] wordChar = word.toCharArray();
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (existed(board, i, j, wordChar, 0)){
                   return true;
               }
            }
        }
        return false;
    }

    public boolean existed(char[][] board, int x , int y,  char[] word, int index) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == ' ') {
            return false;
        }
        if ( board[x][y] != word[index]) {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }
        char temp = board[x][y];
        board[x][y] = ' ';
        boolean ex = existed(board, x + 1, y, word, index+1)
                || existed(board, x - 1, y, word,index+1)
                || existed(board, x, y + 1, word,index+1)
                || existed(board, x, y - 1, word, index+1);
        board[x][y] = temp;

        return ex;
    }

}
