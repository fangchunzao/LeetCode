package com.leetcode.iv.dic;

/**
 * description 面试题 05.06. 整数转换
 *
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:
 *
 * A，B范围在[-2147483648, 2147483647]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-integer-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-15 20:06:12
 */
public class Dic05_06 {

    public int convertInteger(int A, int B) {


        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((A & 1) != (B & 1)) {
                cnt++;
            }
            A >>>= 1;
            B >>>= 1;
        }
        return cnt;
    }

}
