package com.leetcode.train.array;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FCZ
 * @since 2018/11/2 09:30
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class String1 {

    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) return null;
        String result = "";

        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int length = aLength > bLength ? aLength : bLength;
        int flag = 0; // 是否进位
        for (int i = length,j = 0; i >= 0; i--,j++) {
            char aValue = 0,bValue = 0;
            if (bLength == aLength) {
                aValue = a.charAt(i);
                bValue = b.charAt(i);
            }
            if (aLength < length) {
                if (aLength - j >= 0)
                    aValue = a.charAt(aLength - j);
                else aValue = '0';
                bValue = b.charAt(i);
            }
            if (bLength < length) {
                if (bLength - j >= 0)
                    bValue = b.charAt(bLength - j);
                else bValue = '0';
                aValue = a.charAt(i);
            }
            int value = aValue + bValue + flag - '0';
            if (value > '1') {  // 进位
                flag = 1;
            } else {
                flag = 0;
            }
            result = (value % 2) + result;
        }
        if (flag == 1) {
            result = "1" + result;
        }
        return result;
    }
    public static String addBinary1(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) return null;
        String result = "";
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int length = aLength > bLength ? aLength : bLength;
        int flag = 0; // 是否进位
        for (int i = length,j = 0; i >= 0; i--,j++) {
            int aValue = 0,bValue = 0;
            if (bLength == aLength) {
                aValue = Integer.valueOf(String.valueOf(a.charAt(i)));
                bValue = Integer.valueOf(String.valueOf(b.charAt(i)));
            }
            if (aLength < length) {
                if (aLength - j >= 0)
                    aValue = Integer.valueOf(String.valueOf(a.charAt(aLength - j)));
                else aValue = 0;
                bValue = Integer.valueOf(String.valueOf(b.charAt(i)));
            }
            if (bLength < length) {
                if (bLength - j >= 0)
                    bValue = Integer.valueOf(String.valueOf(b.charAt(bLength - j)));
                else bValue = 0;
                aValue = Integer.valueOf(String.valueOf(a.charAt(i)));
            }
            int value = aValue + bValue + flag;
            if (value > 1) {  // 进位
                flag = 1;
            } else {
                flag = 0;
            }
            result = (value % 2) + result;
        }
        if (flag == 1) {
            result = "1" + result;
        }
        return result;
    }
}
