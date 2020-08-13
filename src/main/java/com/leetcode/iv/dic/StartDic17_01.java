package com.leetcode.iv.dic;

/**
 * description 面试题 17.01. 不用加号的加法
 *
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-without-plus-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-08-12 11:12
 */
public class StartDic17_01 {

    public int add(int a, int b) {
        int sum = 0, carry = 0;
        while(b != 0) {
            sum = a ^ b;			// 异或计算未进位的部分
            carry = (a & b) << 1;	// 进位部分
            a = sum;				// 保存未进位部分，再次计算
            b = carry;				// 保存进位部分，再次计算
        }
        return a;	// 最后无进位，异或的结果即加法结果
    }

}
