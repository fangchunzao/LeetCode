package com.leetcode.iv.offer;

/**
 * description 面试题65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 *
 * 提示：
 *
 * a,b均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fcz
 * @since 2020-06-16 10:09
 *
 * @since 2020-08-25 复习
 **/
public class Offer65 {

    /**
     * 不能用 + - * / 那肯定是要使用位运算了
     * a(i)     b(i)	无进位和 n(i)	进位 c(i+1)
     * 0	    0	    0	           0
     * 0	    1	    1	            0
     * 1	    0	    1	            0
     * 1	    1	    0	            1
     *
     * 观察发现，无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）
     *
     * 循环求出 无进位和 进位
     */
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            // c 是进位 需要左移一位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;

    }

}
