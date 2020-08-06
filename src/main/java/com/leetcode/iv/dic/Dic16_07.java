package com.leetcode.iv.dic;

/**
 * description 面试题 16.07. 最大数值
 *
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 * 示例：
 *
 * 输入： a = 1, b = 2
 * 输出： 2
 *
 * @author fcz
 * @since 2020-08-06 16:38
 */
public class Dic16_07 {

    public int maximum(int a, int b) {
        long x = (long) a - (long) b;
        // long 右移63 可以获取符号位 1为负 0为正
        int k = (int) (x >> 63);
        // k 负 == -1  正 == 0
        return (1 + k) * a - b * k;

    }

}
