package com.leetcode.iv.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题12. 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer12 {

    public static void main(String[] args) {
        Offer12 obj = new Offer12();
/*        System.out.println(obj.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','E','E','E'}
        }, "ABCCED"));  */
        System.out.println(obj.exist(new char[][]{
                {'A'},

        }, "A"));

    }
    // 广度优先算法
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word, int x, int y, int index) {
        if (word.length() == index)
            return true;

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;

        char ch = board[x][y];
        char s = word.charAt(index);
        boolean res = false;
        if (ch == s) {
            board[x][y] = ' ';
            res = exist(board, word, x + 1, y, index + 1) || exist(board, word, x - 1, y, index + 1) ||
                    exist(board, word, x, y + 1, index + 1) || exist(board, word, x, y - 1, index + 1);
            board[x][y] = ch;
        }
        return res;
    }

}

