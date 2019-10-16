package com.leetcode;

import java.util.*;

/**
 * @author FCZ 
 * @since 2018/12/14 10:18
 */
public class Test {

    public static void main(String[] args) {
        String str =
                "";
        System.out.print(str.split(",").length);
    }

    public boolean judgeCircle(String moves) {
        int hang = 0; // 计算行
        int lie = 0;  // 计算列
        for (int i = 0; i < moves.length(); i++) {
            char symbol = moves.charAt(i);
            switch (symbol) {
                case 'R' : hang++; break; // 右
                case 'L' : hang--; break; // 左
                case 'U' : lie++; break; // 上
                case 'D' : lie--; break; // 下
            }
        }
        return hang == 0 && lie == 0;
    }

    public boolean dasds(String moves) {
        int[] count = new int[26];
        for (char c : moves.toCharArray())
            count[c - 'A']++;
        return (count['U' - 'A'] == count['D' - 'A'] && count['L' - 'A'] == count['R' - 'A']);
    }

}
