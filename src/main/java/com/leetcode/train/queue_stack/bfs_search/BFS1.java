package com.leetcode.train.queue_stack.bfs_search;

/**
 * @author FCZ
 * @since 2018/9/29 10:38
 * 岛屿的个数
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 */
public class BFS1 {


    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }

    /**
     * description: 使用广度优先进行遍历
     * @param grid: 二维网格
     * @author FCZ
     * @since 2018-09-29
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                // 注意char
                if (grid[i][j] == '1') {
                    // 发现一个岛 使用深度优先算法向四周找
                    count++;
                    dfsSearch(grid, i, j, rows, cols);
                }
        return count++;
    }

    // 每遇到'1'后, 开始向四个方向 递归搜索. 搜到后变为'0 ',
    // 因为相邻的属于一个island. 然后开始继续找下一个'1'.
    private static void dfsSearch(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols)
            return;
        if (grid[i][j] != '1')
            return;
        // 向四周遍历
        grid[i][j] = '0';
        dfsSearch(grid, i + 1, j, rows, cols);
        dfsSearch(grid, i - 1, j, rows, cols);
        dfsSearch(grid, i, j + 1, rows, cols);
        dfsSearch(grid, i, j - 1, rows, cols);
    }

}
