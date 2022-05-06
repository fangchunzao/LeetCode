package com.leetcode.iv.offer;

/**
 * 面试题15. 二进制中1的个数
 *
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2。
 *
 *
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-09 复习
 */
public class Offer15 {

    public static void main(String[] args) {
        Offer15 obj = new Offer15();
        obj.hammingWeight1(129);
    }

    // 位运算 按位与
    public int hammingWeight1(int n) {
        int res = 0;
        while(n != 0) {
            // 进行&运算 1&1=1 0&1=0
            res += n & 1;
            // 右移1位
            n = n >>> 1;
        }
        return res;
    }

    // 方法2 巧用n-1
    public int hammingWeight2(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            // 与 当前数字 -1 进行与运算 每次都会减少一个1 循环结束 也就是1没了
            n = n & (n - 1);
        }
        return res;
    }



}
