package com.leetcode.iv.offer;

/**
 * description 面试题64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-06-10 15:21
 **/
public class Offer64 {

    public static void main(String[] args) {

    }

    public int sumNums(int n) {
        // 使用&&的规则 判断n的条件
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    /**
     * 递归迭代 （不能用if）
     */
    public int sumNums1(int n) {
        if (n == 0) return 0;
        int preN = sumNums(n - 1);
        return n + preN;
    }

    /**
     * 等差数列求和 （不能用乘除法）
     * (a1 + an)n / 2
     */
    public int sumNums2(int n) {
        return (1 + n) * n / 2;
    }




}
