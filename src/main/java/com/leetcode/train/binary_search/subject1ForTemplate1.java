package com.leetcode.train.binary_search;

/**
 * @Description: x 的平方根
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class subject1ForTemplate1 {

    public static void main(String[] args) {
        System.out.println(mySqrt(25));
    }

    /**
     *  x = 8
     *  {0,1,2,3,4,5,6,7,8}
     *  在临界区（也就是 2*2 < x < 3*3），2、3之间取值
     *  应当取得较小的数，因为小数部分会省略。
     *  int mid = left + (right - left) / 2;  会取到两者中较小的数字
     *  如果此时left = 2,right = 3, 计算得到mid = 2;
     *  通过if判断 x > 2*2 ; left = mid. mid一直等于2，会造成死循环
     *
     *  因此，我们可以先取到较大的数，使用 较大的数-1 就是结果
     */
    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 0, right = 46341;  // 当X为int的最大值时
        while (left < right) {
            int mid = left + (right - left) / 2;
            int value = mid * mid;
            if (x >= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

}
