package com.leetcode.iv.dic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description 面试题 08.12. 八皇后 (N皇后)
 *
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *
 * 示例:
 *
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-28 21:08:25
 */
public class StartDic08_12 {

    // W 0 0 0  // row = 0 col = 2
    // 0 0 0 W
    // 0 0 0 0  // currRow = 2
    // 0 0 0 0
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] nums = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nums[i], '.');
        }
        backtrack(nums,0, ans);
        return ans;
    }

    private void backtrack(char[][] nums, int QRow, List<List<String>> ans) {
        int len = nums.length;
        if (len == QRow) {
            // 保存结果
            List<String> path2 = new ArrayList<>();
            for (char[] num : nums) {
                path2.add(String.valueOf(num));
            }
            ans.add(path2);
            return;
        }

        for (int qCol = 0; qCol < len; qCol++) {
            //判断这个位置是否合适
            boolean isok = true;
            for (int row = 0; row < QRow; row++) {
                //竖的有Q
                if (nums[row][qCol] == 'Q') {
                    isok = false;
                    break;
                }
                //判断对角线
                if (qCol + (QRow - row) < len && nums[row][qCol + (QRow - row)] == 'Q') {
                    isok = false;
                    break;
                }
                if (qCol - (QRow - row) >= 0 && nums[row][qCol - (QRow - row)] == 'Q') {
                    isok = false;
                    break;
                }
            }
            if (!isok) {
                continue;
            }
            //满足条件
            nums[QRow][qCol] = 'Q';
            backtrack(nums, QRow + 1, ans);
            nums[QRow][qCol] = '.';
        }
    }

}
