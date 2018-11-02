package com.leetcode.train.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FCZ
 * @since 2018/11/2 09:19
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class TwoArray2 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                list.add(result.get(i-2).get(j-1) + result.get(i-2).get(j));
            }
            if (i > 1)
                list.add(1);
            result.add(list);
        }
        return result;
    }

}
