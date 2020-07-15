package com.leetcode.iv.dic;

/**
 * description 面试题 05.04. 下一个数
 *
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 *
 *  输入：num = 1
 *  输出：[2, -1]
 * 提示:
 *
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closed-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-15 15:59
 */
public class Dic05_04 {

    public static int[] findClosedNumbers(int num) {
        int[] res = new int[]{-1, -1};
        long maxNum = (long)num << 1;
        int minNum = num >>> 1;

        int oneCountNum = calOneCountNum(num);
        for (int i = num + 1; i <= maxNum; i++) {
            if (oneCountNum == calOneCountNum(i)) {
                res[0] = i;
                break;
            }
        }
        for (int i = num - 1; i >= minNum ; i--) {
            if (oneCountNum == calOneCountNum(i)) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    private static int calOneCountNum(long num) {
        int cnt = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                cnt++;
            }
            num >>= 1;
        }
        return cnt;
    }



}
