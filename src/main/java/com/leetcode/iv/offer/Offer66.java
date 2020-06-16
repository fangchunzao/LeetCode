package com.leetcode.iv.offer;

import java.util.Arrays;

/**
 * description 面试题66. 构建乘积数组
 *
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-06-16 14:56
 **/
public class Offer66 {

    public static void main(String[] args) {
        Offer66 obj = new Offer66();
        System.out.println(Arrays.toString(obj.constructArr(new int[]{
                1,2,3,4,5
        })));
    }

    /**
     * 表格分割法
     * 首先初始化数组B，根据题意 数组B的下标b的乘积值，就是数组A不包含下标b的其他元素的乘积
     * 绘制表格 就是延对角线分割的两个三角形
     * 因此可以分别计算上下三角形的乘积计算
     */
    public int[] constructArr(int[] a) {
        if(a.length == 0) return new int[0];
        int[] b = new int[a.length];
        // 计算下侧三角形每个位置的乘积
        b[0] = 1;
        for (int i = 1; i < b.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        // 上侧三角形的乘积
        int high = 1;
        for (int i = b.length - 2; i >= 0; i--) {
            high *= a[i + 1];
            b[i] *= high;
        }
        return b;
    }

    public int[] constructArr2(int[] a) {
        if(a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    /**
     * 暴力法 超时
     */
    public int[] constructArr1(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < res.length; j++) {
                if (i != j)
                    res[j] *= a[i];
            }
        }
        return res;
    }

}
