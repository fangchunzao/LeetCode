package com.leetcode.junior.string;

/**
 * @Auther: FCZ
 * @Description: 字符串转整数（atoi）
 * 实现 atoi，将字符串转为整数。
 *
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 *
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 *
 * 若函数不能执行有效的转换，返回 0。
 * @Date: 2018/9/11 11:15
 */
public class String6 {

    public static void main(String[] args) {
        String s = "-3a1415";
        System.out.println(myAtoi1(s));
    }
    public static int myAtoi1(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        // 正负号标记
        int sign = 1;
        // 转换值
        int base = 0;
        // 索引位数
        int i = 0;
        // 判断正负号
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;
        // 索引有效数字字符
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            // 如果base > MAX_VALUE/10，那么base*10 + new_value > base*10 > MAX_VALUE，这种情况下就会发生溢出。
            // 若base == INT_MAX/10，而且new_value = str.charAt(i++) - '0'`大于`7`，也会发生溢出。因为MAX_VALUE = 2147483647
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 计算转换值
            base = 10 * base + (str.charAt(i++) - '0');
        }
        // 计算结果值
        return base * sign;
    }
}
