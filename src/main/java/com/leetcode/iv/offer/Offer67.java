package com.leetcode.iv.offer;

/**
 * description 面试题67. 把字符串转换成整数
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
 * 作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
 * 则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。如果数值超过这个范围，
 * 请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。
 *
 * 示例1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *     因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-06-16 15:29
 *
 * @since 2020-08-25 复习
 **/
public class Offer67 {

    /**
     * 有以下四种字符需要考虑
     * 1. 首部空格：删除之即可；
     * 2. 符号位： 三种情况，即 '+' , '−' , '无符号' ；新建一个变量保存符号位，返回前判断正负即可。
     * 3. 非数字字符：遇到首个非数字的字符时，应立即返回。
     * 4. 数字字符：
     *   a.字符转数字： “此数字的 ASCII 码” 与 “ 0 的 ASCII 码” 相减即可；
     *   b.数字拼接： 若从左向右遍历数字，设当前位字符为 c ，当前位数字为 x ，数字结果为 res，
     *   则数字拼接公式为：res = 10 × res + x
     *                    x = ascii(c)−ascii('0')
     *
     * 数字越界处理：
     * 题目要求返回的数值范围应在int最大范围内
     * 因此需要考虑数字越界问题。而由于题目指出 环境只能存储 32 位大小的有符号整数 ，
     * 因此判断数字越界时，要始终保持 res在 int 类型的取值范围内
     *
     * 在每轮数字拼接前，判断 res在此轮拼接后是否超过 2147483647
     * 若超过则加上符号位直接返回
     */
    public int strToInt(String str) {
        char[] strChar = str.trim().toCharArray();
        if (strChar.length <= 0)
            return 0;
        int maxInt = Integer.MAX_VALUE / 10;
        int res = 0;
        // 判断正负
        boolean sigh = true;
        // 下标开始位置 从1开始跳过符号
        int index = 1;
        if (strChar[0] == '-') {
            sigh = false;
        } else if (strChar[0] != '+'){
            // 首字符不是符号
            index = 0;
        }
        // 遍历每一位 进行计算
        for (int i = index; i < strChar.length; i++) {
            // 判断是否为数字 非数字跳出循环
            if (strChar[i] < '0' || strChar[i] > '9')
                break;
            // 判断当前的res是否会越界
            if (res > maxInt || (res == maxInt && strChar[i] > '7')) {
                return sigh ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10 * res + (strChar[i] - '0');
        }
        return res * (sigh ? 1 : -1);
    }



    public int strToInt1(String str) {
        // 去掉首尾空格
        char[] c = str.trim().toCharArray();
        if(c.length == 0)
            return 0;
        int res = 0;
        int bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        // 判断符号位
        if(c[0] == '-')
            sign = -1;
        else if(c[0] != '+')
            i = 0;

        for(int j = i; j < c.length; j++) {
            // 非数字 跳出
            if(c[j] < '0' || c[j] > '9') break;
            // 数字越界
            if(res > bndry || res == bndry && c[j] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            // 计算结果
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }



}
