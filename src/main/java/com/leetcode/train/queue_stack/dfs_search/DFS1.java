package com.leetcode.train.queue_stack.dfs_search;

/**
 * @author FCZ
 * @since 2018/10/29 15:37
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
public class DFS1 {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','1','0'},
                {'0','0','0','1','0'},
                {'1','1','0','1','1'},
                {'0','0','1','1','0'}
        };
        char[][] grid1 = {
                {'1'},
                {'1'}
        };
        System.out.println(numIslands(grid1));
    }
    // 深度优先算法 如果使用广度优先算法，加一个列表，判断每个元素不能重复
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[x].length - 1 || grid[x][y] == '0') return;
        grid[x][y] = '0';
        // 四周扩散
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }

}
