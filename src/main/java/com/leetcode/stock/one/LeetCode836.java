package com.leetcode.stock.one;

/**
 * 836. 矩形重叠
 *
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 *
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 * 提示：
 *
 * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
 * 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 * x 轴默认指向右，y 轴默认指向上。
 * 你可以仅考虑矩形是正放的情况。
 *
 * 示例 1：
 *
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 *
 */
public class LeetCode836 {

    public static void main(String[] args) {

    }

    // 题目条件实在坐标系中 别弄反了。 x 轴默认指向右，y 轴默认指向上。
    // 如果不相交 需要满足
    // rec1[x2] <= rec2[x1]
    // rec1[x1] >= rec2[x2]
    // rec1[y1] >= rec2[y2]
    // rec1[y2] <= rec2[y1]
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 相交返回false  不相交返回true
        return !(rec1[2] <= rec2[0] ||
                rec1[0] >= rec2[2] ||
                rec1[1] <= rec2[3] ||
                rec1[3] >= rec2[1]);
    }

    // 找出可行域
    // r1 [x1,y1,x2,y2]
    //   x1 < x < x2   y1 < y < y2
    // r2 [x3,y3,x4,y4]
    //   x3 < x < x4   y3 < y < y4
    // 合并
    //  MAX(x1,x3) < x < MIN(x2,x4)
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        return  (Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2])) &&
                (Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]));
    }



}