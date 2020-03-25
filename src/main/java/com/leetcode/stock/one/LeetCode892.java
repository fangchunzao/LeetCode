package com.leetcode.stock.one;

/**
 * @author fcz
 * @description 892. 三维形体的表面积
 *
 *在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020-03-25 11:21
 **/
public class LeetCode892 {

    public static void main(String[] args) {

    }

    // 读懂题很重要
    // [[1,2],[3,4]]
    // 就是一个 2*2 的网格，00位置放一个 01位置放2个 10位置放3个 11位置放4个 计算表面积
    public int surfaceArea(int[][] grid) {

        int N = grid.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] != 0){
                    count += grid[i][j] * 4 + 2;
                }
                // 减去当前位置与前一个位置重叠的部分
                if(j > 0) {
                    int m = Math.min(grid[i][j - 1], grid[i][j]);
                    count -= m * 2;
                }
                if(i > 0) {
                    int n = Math.min(grid[i - 1][j], grid[i][j]);
                    count -= n * 2;
                }
            }
        }
        return count;
    }

}
