package com.leetcode.iv.offer;

/**
 * 面试题13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 *
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 *
 * 请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer13 {

    public static void main(String[] args) {
        Offer13 obj = new Offer13();
        System.out.println(obj.movingCount(35,37,18));
    }

    public int movingCount(int m, int n, int k) {
        matrix = new boolean[m][n];
        return movingCount(m, n, k, 0, 0);
    }

    boolean[][] matrix;

    // 广度优先算法 BFS
    // 向四周寻找
    public int movingCount(int m, int n, int k, int x, int y) {
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || matrix[x][y])
            return 0;

        int sum = 0;
        int tempX = x;
        while (tempX > 0) {
            sum += tempX % 10;
            tempX /= 10;
        }
        int tempY = y;
        while (tempY > 0) {
            sum += tempY % 10;
            tempY /= 10;
        }
        if (sum > k)
            return 0;
        matrix[x][y] = true;
        int count = 1;
        count += movingCount(m, n, k, x - 1, y);
        count += movingCount(m, n, k, x + 1, y);
        count += movingCount(m, n, k, x, y - 1);
        count += movingCount(m, n, k, x, y + 1);

        return count;
    }

    // 深度优先算法DFS 向边界找 进行回溯
    int m, n, k;
    boolean[][] visited;
    public int movingCount1(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    /**
     *
     * @param i 横坐标
     * @param j 纵坐标
     * @param si 用于计算横坐标的数位和
     * @param sj 用于计算纵坐标的数位和
     * @return
     */
    public int dfs(int i, int j, int si, int sj) {
        if(i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j])
            return 0;

        visited[i][j] = true;
        // (i + 1) % 10 != 0 ? si + 1 : si - 8 用于计算横坐标的数位和
        // (j + 1) % 10 != 0 ? sj + 1 : sj - 8 用于计算纵坐标的数位和
        return 1 +
                dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) +
                dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }


}
