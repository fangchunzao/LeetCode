package com.leetcode.train.binary_search;

/**
 * @Auther: FCZ
 * @Description:
 * @Date: 2018/9/12 11:17
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
