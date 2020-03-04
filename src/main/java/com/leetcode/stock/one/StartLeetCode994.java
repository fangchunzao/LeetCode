package com.leetcode.stock.one;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 * 提示：
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class StartLeetCode994 {

    public static void main(String[] args) {

    }

    // dr,dc 配合使用得到 grid[r][c] 上grid[r-1][c]左grid[r][c-1]下grid[r+1][c]右grid[r][c+1]的元素
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        // queue : all starting cells with rotten oranges
        // 存储腐烂橙子的坐标
        Queue<Integer> queue = new ArrayDeque<>();
        // 存储每一个腐烂橙子的天数
        Map<Integer, Integer> depth = new HashMap<>();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (grid[r][c] == 2) {
                    // 转化为横纵坐标的一维数组
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            // 将坐标算出来
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                // 广度优先 向四周查找
                int nr = r + dr[k];
                int nc = c + dc[k];
                // 满足条件 当前位置为新鲜橙子
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    // 变成烂橙子
                    grid[nr][nc] = 2;
                    // 转换新坐标坐标
                    int ncode = nr * C + nc;
                    // 放入队列中
                    queue.add(ncode);
                    //  并记录这个橙子腐烂的天数 天数为上一个腐烂橙子天数 + 1
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;

    }

}
