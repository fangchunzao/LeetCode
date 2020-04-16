package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * @author fcz
 * @description 56. 合并区间
 *
 *给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020-04-16 17:25
 **/
public class LeetCode56 {

    public static void main(String[] args) {

    }

    // 首先排序
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] res = new int[intervals.length][2];
        int index = -1;
        for(int[] interval : intervals) {
            // 判断不在区间内
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {
                // 存在区间内
                res[index][1] = Math.max(interval[1], res[index][1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }

}
