package com.leetcode.iv.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fcz
 * @description 面试题44. 数字序列中某一位的数字
 *
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 *
 *
 * 限制：
 *
 * 0 <= n <2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-25 复习
 **/
public class StartOffer44 {

    public static void main(String[] args) {
        StartOffer44 obj = new StartOffer44();
        obj.findNthDigit(10);
    }


    // 找规律 数学法
    // 规律 0~9有10个数字，10~99有90个数字，100~999有900个数字 1000~9999 9000个数字
    public int findNthDigit(int n) {
        if (n < 10)
            return n;
        n--; // 不计算 0
        int digits = 1; // 位数
        long base = 1;  // 会越界
        // 找n 是几位数
        while (n > 9 * base * digits) {
            n -= 9 * base * digits;
            base *= 10;
            digits++;
        }
        // 计算得出 n 位置上的数字  base是之前数字总个数  n是剩下的数字个数 digits是目标数字的位数
        String num = String.valueOf(base + n / digits);
        // 计算出第几位数字
        int index = n % digits;
        return num.charAt(index) - '0';
    }

    public int findNthDigit2(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // (n - 1)的原因 start为起始位置包含了开始的位置
        // 当n=11  1234567891[0]1112
        // 经过一轮循环  n = 2, 表示是二位数字的第二个
        // 因为从start开始 start包含了开始的位置 需要 n-1 才能计算出准确的结果
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }


    // 暴力穷举出所有的数字 超时
    public int findNthDigit1(int n) {
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n;) {
            if (num < 10) {
                list.add(i, num);
                i++;
            } else {
                // 多位数字
                char[] numChar = String.valueOf(num).toCharArray();
                for (int j = 0; j < numChar.length && i <= n; j++) {
                    list.add(numChar[j] - '0');
                    i++;
                }
            }
            num++;
        }
        return list.get(n);
    }

}
