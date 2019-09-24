package com.leetcode.stock.one;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 150. 逆波兰表达式求值
 *
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/24 14:25
 **/
public class LeetCode150 {

    public static void main(String[] args) {
        LeetCode150 obj = new LeetCode150();
        System.out.println(obj.evalRPN(new String[]{"1" ,"1","+","-","1"}));

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        for(String str : tokens) {
            // 数字放入栈中
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i)) && i == str.length() - 1) {
                    stack.push(Integer.valueOf(str));
                }
            }
            // 进行计算
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                queue.add(str);
            }
            if (queue.size() > 0 && stack.size() > 1) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                String symbol = queue.poll();
                stack.push(calculate(num2, num1, symbol));
            }
        }
        return stack.pop();
    }

    public int calculate(int num1, int num2, String symbol) {
        switch (symbol) {
            case "+" : return num1 + num2;
            case "-" : return num1 - num2;
            case "*" : return num1 * num2;
            case "/" :
                if (num2 == 0) return -1;
                return num1 / num2;
        }
        return -1;
    }

}
