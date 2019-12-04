package com.leetcode.stock.one;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 输入："234"
 * 输出：["adg", "adh", "adi", "aeg","aeh","aei", "afg", "afh", "afi", "bdg", "bdh", "bdi", "beg","beh","bei", "bfg", "bfh", "bfi",]

 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author fcz
 * @description
 * @date 2019-12-04 15:47
 **/
public class LeetCode17 {

    public static void main(String[] args) {
        LeetCode17 obj = new LeetCode17();
        System.out.println(obj.letterCombinations1("237"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        // 初始化字符
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> two = new ArrayList<String>() {{add("a");add("b");add("c");}};
        List<String> three = new ArrayList<String>() {{add("d");add("e");add("f");}};
        List<String> four = new ArrayList<String>() {{add("g");add("h");add("i");}};
        List<String> five = new ArrayList<String>() {{add("j");add("k");add("l");}};
        List<String> six = new ArrayList<String>() {{add("m");add("n");add("o");}};
        List<String> seven = new ArrayList<String>() {{add("p");add("q");add("r");add("s");}};
        List<String> eight = new ArrayList<String>() {{add("t");add("u");add("v");}};
        List<String> nine = new ArrayList<String>() {{add("w");add("x");add("y");add("z");}};
        map.put(2, two);
        map.put(3, three);
        map.put(4, four);
        map.put(5, five);
        map.put(6, six);
        map.put(7, seven);
        map.put(8, eight);
        map.put(9, nine);
        // 计算结果数组长度
        int length = 1;
        for (int i = 0; i < digits.length(); i++) {
            length *= map.get(digits.charAt(i) - '0').size();
        }
        String[] result = new String[length];
        Arrays.fill(result, "");
        // 从后往前依次放入字母
        int repeat = 1;  // 当前字母重复次数
        int space = map.get(digits.charAt(digits.length() - 1) - '0').size();  //  字母每次的间隔
        for (int i = digits.length() - 1; i >= 0; i--) {
            Integer num = digits.charAt(i) - '0';
            List<String> numList = map.get(num);
            if (i !=  digits.length() - 1) {  // 第一次初始化不需要
                space *= numList.size();
            }
            // 每一个字母
            for (int j = 0; j < numList.size(); j++) {
                int index = repeat * j;  // 开始位置的索引
                // 开始位置
                for (int k = index; k < length; k = k + space) {
                    // 重复次数
                    for (int l = 0; l < repeat; l++) {
                        result[k + l] = numList.get(j) + result[k + l];
                    }
                }
            }
            // 重复次数递乘
            repeat *= numList.size();
        }
        return Arrays.asList(result);
    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations1(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
         if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
             String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
             for (int i = 0; i < letters.length(); i++) {
                  String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                 backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

}
