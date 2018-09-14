package com.leetcode.train.binary_search;

/**
 * @Description: 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class subject2ForTemplate1 {


    private static int number = 6;

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    public static int guessNumber(int n) {
        int left = 0, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    static int guess(int num) {
        if (number == num) {
            return 0;
        } else if (number > num) {
            return 1;
        } else {
            return -1;
        }
    }

}
