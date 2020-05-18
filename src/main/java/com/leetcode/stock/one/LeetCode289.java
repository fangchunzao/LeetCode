package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * @author fcz
 * @description 289. 生命游戏
 *
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *  
 *
 * 进阶：
 *
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020-04-02 14:25
 **/
public class LeetCode289 {

    public static void main(String[] args) {
        LeetCode289 obj = new LeetCode289();
        obj.gameOfLife(new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        });
    }

    // 借助复制空间
    // 时间复杂度 O(MN) 空间复杂度 O(MN)
    public void gameOfLife(int[][] board) {

        int[] dx = {-1, -1, -1, 0 , 0, 1, 1, 1};
        int[] dy = {-1 , 0, 1, 1, -1, -1, 0 ,1};

        int[][] ans = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            ans[i] =  Arrays.copyOf(board[i], board[i].length);
        }

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {

                int liveCellCount = 0;
                // 计算四周活细胞数量
                for (int k = 0; k < dx.length; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && y >= 0 && x < ans.length && y < ans[0].length && ans[x][y] == 1)
                        liveCellCount++;
                }
                if (ans[i][j] == 1) {
                    if (liveCellCount < 2 || liveCellCount > 3)
                        board[i][j] = 0;
                } else {
                    if (liveCellCount == 3)
                        board[i][j] = 1;
                }

            }
        }

    }

    // 数组原地改变 不借助复制空间
    // 时间复杂度 O(MN) 空间复杂度 O(1)
    public void gameOfLife1(int[][] board) {
        int[] dx = {-1, -1, -1, 0 , 0, 1, 1, 1};
        int[] dy = {-1 , 0, 1, 1, -1, -1, 0 ,1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 根据不同条件
                // 活 -> 死 赋值 -1
                // 活 -> 活 赋值1
                // 死 -> 活 赋值2
                // 计算周围活着的细胞个数
                int liveCellCount = 0;
                for (int k = 0; k < dx.length; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    // 一直活着的 和之前活着的 +1
                    if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && (board[x][y] == 1 || board[x][y] == -1))
                        liveCellCount++;
                }
                if (board[i][j] == 1) {
                    if (liveCellCount < 2 || liveCellCount > 3)
                        board[i][j] = -1;
                } else {
                    if (liveCellCount == 3)
                        board[i][j] = 2;
                }
            }
        }
        // 将-1 变成 0， 2变成1
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == -1)
                    board[i][j] = 0;
                else if (board[i][j] == 2)
                    board[i][j] = 1;
            }

    }

}
