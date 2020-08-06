package com.leetcode.iv.dic;

/**
 * description 面试题 16.04. 井字游戏
 *
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * 示例 1：
 *
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * 示例 2：
 *
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * 示例 3：
 *
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * 提示：
 *
 * 1 <= board.length == board[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tic-tac-toe-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-08-05 10:09
 */
public class Dic16_04 {

    public static void main(String[] args) {
        Dic16_04 dic = new Dic16_04();
        System.out.println(dic.tictactoe(new String[]{"O X"," XO","X O"}));
    }

    public String tictactoe(String[] board) {

        int length = board.length;

        int left = 0; //左斜线
        int right = 0; //右斜线
        boolean flag = false; //记录有没有空格

        for (int i = 0; i < length; i++) {
            int heng = 0; //横的和
            int zong = 0; //纵的和

            for (int j = 0; j < length; j++) {
                heng = heng + (int) board[i].charAt(j);
                zong = zong + (int) board[j].charAt(i);

                if(board[i].charAt(j) == ' ') flag = true;
            }

            //横纵检查
            if (heng == (int)'X' * length || zong == (int)'X' * length) return "X";
            if (heng == (int)'O' * length || zong == (int)'O' * length) return "O";

            //两条斜线上的相加
            left = left + (int)board[i].charAt(i);
            right = right + (int)board[i].charAt(length - i - 1);

        }

        //两条斜线检查
        if (left == (int)'X' * length || right == (int)'X' * length) return "X";
        if (left == (int)'O' * length || right == (int)'O' * length) return "O";

        if (flag) return "Pending";
        return "Draw";

    }

    // 动态规划
    public String tictactoe1(String[] board) {
        int length = board.length;
        char[][] boardChar = new char[length][length];
        for (int i = 0; i < length; i++) {
            char[] chars = board[i].toCharArray();
            boardChar[i] = chars;
        }
        // 使用DP数组维护当前是否与之前的棋子相同
        // 前两维度代表横纵坐标 第三个维度是 横、竖、正斜、反斜
        // 0 横着 1 竖着 2 正斜 \  3 反斜 /
        boolean[][][] dp = new boolean[length][length][4];
        boolean isEmpty = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (boardChar[i][j] == ' ') {
                    isEmpty = true;
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j][0] = true;
                    dp[i][j][1] = true;
                    dp[i][j][2] = true;
                    dp[i][j][3] = true;
                    continue;
                }
                if (i == 0) {
                    dp[i][j][0] = dp[i][j - 1][0] && boardChar[i][j] == boardChar[i][j - 1];
                    dp[i][j][1] = true;
                    dp[i][j][2] = true;
                    dp[i][j][3] = true;
                    continue;
                }
                if (j == 0){
                    dp[i][j][0] = true;
                    dp[i][j][1] = dp[i - 1][j][1] && boardChar[i][j] == boardChar[i - 1][j];
                    dp[i][j][2] = true;
                    dp[i][j][3] = dp[i - 1][j + 1][3] && boardChar[i][j] == boardChar[i - 1][j + 1];
                    continue;
                }
                dp[i][j][0] = dp[i][j - 1][0] && boardChar[i][j] == boardChar[i][j - 1];
                dp[i][j][1] = dp[i - 1][j][1] && boardChar[i][j] == boardChar[i - 1][j];
                dp[i][j][2] = dp[i - 1][j - 1][2] && boardChar[i][j] == boardChar[i - 1][j - 1];
                if (j < length - 1)
                    dp[i][j][3] = dp[i - 1][j + 1][3] && boardChar[i][j] == boardChar[i - 1][j + 1];
            }
        }
        // 遍历竖着的最后一列 为True 说明横着的是有玩家获胜
        for (int row = 0; row < length; row++) {
            if (dp[row][length - 1][0]) {
                return String.valueOf(boardChar[row][length-1]);
            }
        }
        // 遍历最后一行 为True 说明该列存在玩家获胜
        for (int line = 0; line < length; line++) {
            if (dp[length - 1][line][1]) {
                return String.valueOf(boardChar[length - 1][line]);
            }
        }
        // 左下角判断反斜 / 右下角判断正斜 \
        if (dp[length - 1][0][3]) {
            return String.valueOf(boardChar[length - 1][0]);
        }
        if (dp[length - 1][length - 1][2]) {
            return String.valueOf(boardChar[length - 1][length - 1]);
        }
        return isEmpty?"Pending":"Draw";
    }

}
