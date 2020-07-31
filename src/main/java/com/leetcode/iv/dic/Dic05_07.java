package com.leetcode.iv.dic;

/**
 * description 面试题 05.07. 配对交换
 *
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出 1 (或者 0b01)
 * 示例2:
 *
 *  输入：num = 3
 *  输出：3
 * 提示:
 *
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exchange-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-15 20:10:29
 */
public class Dic05_07 {

    public static int exchangeBits(int num) {
        int one = 0, two = 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (i % 2 == 0) {
                two = num & 1;
            } else {
                one = num & 1;
                res |= (one << (i - 1));
                res |= (two << i);
            }
            num >>>= 1;
        }
        return res;
    }

    // 0x55555555 = 0b0101_0101_0101_0101_0101_0101_0101_0101
    // 0xaaaaaaaa = 0b1010_1010_1010_1010_1010_1010_1010_1010
    public int exchangeBits1(int num) {
        //奇数
        int odd = num & 0x55555555;
        //偶数
        int even = num & 0xaaaaaaaa;
        odd = odd << 1;
        even = even >>> 1;
        return odd | even;
    }


}
