package com.leetcode.iv.dic;

/**
 * description 面试题 08.05. 递归乘法
 *
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 示例1:
 *
 *  输入：A = 1, B = 10
 *  输出：10
 * 示例2:
 *
 *  输入：A = 3, B = 4
 *  输出：12
 * 提示:
 *
 * 保证乘法范围不会溢出
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recursive-mulitply-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-20 21:16:12
 */
public class Dic08_05 {


    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        return mul(min, max);
    }
    public int mul(int A, int B){
        if(A == 0){
            return 0;
        }
        if(A == 1){
            return B;
        }
        if(A == 2){
            return B << 1;
        }
        return mul(2, B) + mul(A-2, B);
    }

    public int multiply(int A, int B, int a) {
        if (B == 0)
            return a;
        return multiply(A, B - 1, a + A);
    }

}
