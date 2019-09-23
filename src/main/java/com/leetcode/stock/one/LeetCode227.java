package com.leetcode.stock.one;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * 227. 基本计算器 II
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/23 15:09
 **/
public class LeetCode227 {

    public static void main(String[] args) {
        LeetCode227 obj = new LeetCode227();
        System.out.println(obj.calculate("1+1-1"));
    }

    public int calculate(String s) {
        Stack<Integer> numberQueue = new Stack<>();
        Stack<Character> symbolQueue = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            // 数字
            if (Character.isDigit(item)) {
                // 后面有多少位数字?
                int endIndex = numberIndex(i, s);
                int num = Integer.parseInt(s.substring(i,endIndex));
                i = endIndex - 1;
                numberQueue.add(num);
                if (flag) {
                    char symbol = symbolQueue.pop();
                    int num1 = numberQueue.pop();
                    int num2 = numberQueue.pop();
                    numberQueue.add(calculate(num2,num1,symbol));
                    flag = false;
                }
                continue;
            }
            // + - 计算
            if (item == '+' || item == '-') {
                symbolQueue.add(item);
                continue;
            }
            // *  / 计算
            if (item == '*' || item == '/') {
                flag = true;
                symbolQueue.add(item);
            }
        }
        // 双栈转队列 憨憨做法
        Stack<Integer> numberQueue1 = new Stack<>();
        Stack<Character> symbolQueue1 = new Stack<>();

        while (!numberQueue.isEmpty()) {
            numberQueue1.push(numberQueue.pop());
        }
        while(!symbolQueue.isEmpty()) {
            symbolQueue1.push(symbolQueue.pop());
        }

        while (!symbolQueue1.isEmpty()) {
            char symbol = symbolQueue1.pop();
            int num1 = numberQueue1.pop();
            int num2 = numberQueue1.pop();
            numberQueue1.add(calculate(num1,num2,symbol));
        }
        return numberQueue1.pop();
    }

    public int numberIndex(int startIndex, String s) {
        for (int i = startIndex; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return i;
            }
            if (i == s.length() - 1) {
                return s.length();
            }
        }
        return -1;
    }

    public int calculate(int num1, int num2, char symbol) {
        switch (symbol) {
            case '+' : return num1 + num2;
            case '-' : return num1 - num2;
            case '*' : return num1 * num2;
            case '/' :
                if (num2 == 0) return -1;
                return num1 / num2;
        }
        return -1;
    }

}
