package com.leetcode.stock.one;

/**
 * @author fcz
 * @description 999. 车的可用捕获量
 *
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020-03-26 17:15
 **/
public class LeetCode999 {

    public int numRookCaptures(char[][] board) {

        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        int count = 0;
        // 向左运动
        for (int i = x; i < board.length; i++) {
            if (board[i][y] == '.')
                continue;
            if (board[i][y] == 'p') {
                count ++;
                break;
            }
            if (board[i][y] == 'B')
                break;
        }
        // 向右运动
        for (int i = x; i >= 0 ; i--) {
            if (board[i][y] == '.')
                continue;
            if (board[i][y] == 'p') {
                count ++;
                break;
            }
            if (board[i][y] == 'B')
                break;
        }
        // 向下运动
        for (int i = y; i < board.length; i++) {
            if (board[x][i] == '.')
                continue;
            if (board[x][i] == 'p') {
                count ++;
                break;
            }
            if (board[x][i] == 'B')
                break;
        }
        // 向上运动
        for (int i = y; i >= 0; i--) {
            if (board[x][i] == '.')
                continue;
            if (board[x][i] == 'p') {
                count++;
                break;
            }
            if (board[x][i] == 'B')
                break;
        }
        return count;
    }

}
