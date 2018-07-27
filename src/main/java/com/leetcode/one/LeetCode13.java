package com.leetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 *  罗马数字转整数
 *  罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 *  示例 1:
 *   输入: "III"
 *   输出: 3
 *
 *  通过判断罗马数，如果前一个数小于后一个数相减，否则相加
 */
public class LeetCode13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        // 将罗马数放入一个Map中，方便读取
        Map<String,Integer> romanMap = new HashMap<String, Integer>() {{
            put("I", 1);put("V", 5);put("X", 10);put("L", 50);put("C", 100);put("D", 500);put("M", 1000);
        }};
        int result = 0;
        int prev = 0; // 前一个值
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            Integer value = romanMap.get(str);
            if (prev < value && i > 0) { // 判断前一个与当前的数，第一次不判断
                // 当前结果减去 计算出的罗马数 再减去之前多加的一个
                result = result + (value - prev) - prev;
            } else {
                result += value;
            }
            prev = value;
        }
        return result;
    }
}
