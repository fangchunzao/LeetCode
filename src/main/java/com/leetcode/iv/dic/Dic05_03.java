package com.leetcode.iv.dic;

/**
 * description 面试题 05.03. 翻转数位
 *
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * 示例 1：
 *
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 *
 * 输入: num = 7(01112)
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-15 14:54
 */
public class Dic05_03 {

    // 双指针
    // 利用双指针记录上一个0 1的最大长度
    public static int reverseBits(int num) {
        int cnt1 = 1;
        int pos = -1;
        int result = 0;
        for (int i = 0; i < 33; i++) {
            if ((num & 1) == 1) {
                cnt1++;
            } else {
                result = Math.max(result, cnt1);
                cnt1 = i - pos;
                pos = i;
            }
            num >>>= 1;
        }
        return result;

    }

}
