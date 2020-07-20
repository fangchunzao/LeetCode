package com.leetcode.iv.dic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description 面试题 08.02. 迷路的机器人
 *
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
 * 设计一种算法，寻找机器人从左上角移动到右下角的路径。

 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-16 15:25
 */
public class Dic08_02 {

    public static void main(String[] args) {
        pathWithObstacles(new int[][]{
                {1},
        });
    }

    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0  || obstacleGrid[0] == null || obstacleGrid[0].length == 0)
            return new ArrayList<>();
        return pathWithObstacles(obstacleGrid, new ArrayList<>(), 0, 0);

    }

    // DFS
    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid, List<List<Integer>> resList, int x, int y) {
        if (x < 0 || x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1 || obstacleGrid[x][y] == -1){
            return new ArrayList<>();
        }
        // 记录已经走过的路径
        obstacleGrid[x][y] = -1;

        resList.add(Arrays.asList(x, y));
        // 成功到达目的地
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return resList;
        }
        List<List<Integer>> xList = pathWithObstacles(obstacleGrid, resList, x + 1, y);
        if (!xList.isEmpty())
            return xList;
        List<List<Integer>> yList = pathWithObstacles(obstacleGrid, resList, x, y + 1);
        if (!yList.isEmpty()) {
            return yList;
        }
        resList.remove(resList.size() - 1);
        return new ArrayList<>();
    }

    public static List<List<Integer>> pathWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0  || obstacleGrid[0] == null || obstacleGrid[0].length == 0)
            return new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();
        pathWithObstacles2(obstacleGrid, resList, 0, 0);
        return resList;
    }

    // 返回值 List<List<Integer>>  的意义用于判断是否已经找到答案 可以使用boolean替
    public static boolean pathWithObstacles2(int[][] obstacleGrid, List<List<Integer>> resList, int x, int y) {
        if (x < 0 || x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1 || obstacleGrid[x][y] == -1){
            return false;
        }
        obstacleGrid[x][y] = -1;
        resList.add(Arrays.asList(x, y));
        // 成功到达目的地
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return true;
        }
        boolean xB = pathWithObstacles2(obstacleGrid, resList, x + 1, y);
        if (xB)
            return true;
        boolean yb = pathWithObstacles2(obstacleGrid, resList, x, y + 1);
        if (yb) {
            return true;
        }
        resList.remove(resList.size() - 1);
        return false;
    }

}
