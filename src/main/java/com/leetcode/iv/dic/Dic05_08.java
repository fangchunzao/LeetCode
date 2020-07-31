package com.leetcode.iv.dic;

/**
 * description 面试题 05.08. 绘制直线
 *
 * 绘制直线。有个单色屏幕存储在一个一维数组中，使得32个连续像素可以存放在一个 int 里。
 * 屏幕宽度为w，且w可被32整除（即一个 int 不会分布在两行上），屏幕高度可由数组长度及屏幕宽度推算得出。
 * 请实现一个函数，绘制从点(x1, y)到点(x2, y)的水平线。
 *
 * 给出数组的长度 length，宽度 w（以比特为单位）、直线开始位置 x1（比特为单位）、直线结束位置 x2（比特为单位）、直线所在行数 y。返回绘制过后的数组。
 *
 * 示例1:
 *
 *  输入：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
 *  输出：[3]
 *  说明：在第0行的第30位到第31为画一条直线，屏幕表示为[0b000000000000000000000000000000011]
 * 示例2:
 *
 *  输入：length = 3, w = 96, x1 = 0, x2 = 95, y = 0
 *  输出：[-1, -1, -1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/draw-line-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-15 20:35:10
 */
public class Dic05_08 {

    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ret = new int[length];
        // 注意根据所在行数计算偏移量
        int offset = y * w / 32;
        // 首位数字下标
        int head = x1 / 32 + offset;
        // 末位数字下标
        int rear = x2 / 32 + offset;
        // 把涉及到的数全部置 -1 也就是 0b11111111111111111111111111111111
        for (int i = head; i <= rear; i++)
            ret[i] = -1;
        // 调整首位数字
        ret[head] = ret[head] & -1 >>> x1 % 32;
        // 调整末位数字
        ret[rear] = ret[rear] & Integer.MIN_VALUE >> x2 % 32;
        return ret;
    }

}
