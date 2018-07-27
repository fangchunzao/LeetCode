package com.leetcode.one;

/**
 * @author FangChunZao
 * @Description:
 * @date 2018/7/18
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 122222 22221
 * 示例 1:
 * 输入: 121
 * 输出: true
 */
public class LeetCode9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12344321));
    }

    public static boolean isPalindrome(int x) {
        // 如果数字的最后一位是 0,肯定不是回文
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while (revertedNumber < x) {
            revertedNumber = (x % 10) + (10 * revertedNumber);
            x /= 10;
        }
        return revertedNumber == x || x == (revertedNumber / 10);
    }
}
