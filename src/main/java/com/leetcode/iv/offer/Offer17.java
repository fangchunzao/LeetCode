package com.leetcode.iv.offer;

import java.util.Arrays;

/**
 * 面试题17. 打印从1到最大的n位数
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer17 {

    public static void main(String[] args) {
        Offer17 obj = new Offer17();
        System.out.println(Arrays.toString(obj.printNumbers(3 )));
    }

    public int[] printNumbers(int n) {
        if (n <= 0 ) return null;

        // 算出最大长度 可以使用pow方法，求10的阶乘
        int numIndex = 1;
        while (n-- > 0) {
            numIndex *= 10;
        }
        int[] result = new int[numIndex - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }


}
