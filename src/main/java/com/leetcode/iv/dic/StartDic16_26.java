package com.leetcode.iv.dic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * description 面试题 16.26. 计算器
 *
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
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
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculator-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-08-04 10:28
 */
public class StartDic16_26 {

    // 1. 如果碰到数字， 则把数字入栈
    // 2. 如果碰到空格， 则继续下一步
    // 3. 如果碰到 '+' '-' '*' '/', 则查找下一个数字num
    //    A.如果是'+', 下一个数字num直接入栈
    //    B.如果是'-'，-num入栈
    //    C.如果是'*', num = stack.pop() * num, 入栈
    //    D.如果是'/', num = stack.pop() / num, 入栈
    // 4. 最后，把栈里的数相加就是结果
    public int calculate(String s) {
        char[] strChar = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        while (index < strChar.length) {
            char ch = strChar[index];
            if (ch == ' ') {
                index++;
                continue;
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                index++;
                // 后面可能存在空格
                while (index < strChar.length && strChar[index] == ' ')
                    index++;
            }
            // 获取接下来的数字
            int num = 0;
            while (index < strChar.length && (strChar[index] >= '0' && strChar[index] <= '9')) {
                num = num * 10 + (strChar[index] - '0');
                index++;
            }
            // 判断当前是否需要计算 如果是符号就进行计算
            switch (ch) {
                case '-': num = -num; break;
                case '*': num = deque.pop() * num; break;
                case '/': num = deque.pop() / num; break;
                default: break;
            }
            deque.push(num);
        }
        int ans = 0;
        while (!deque.isEmpty()) {
            ans += deque.pop();
        }
        return ans;
    }


    /**
     * description 224. 基本计算器
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     *
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     *
     * 示例 1:
     *
     * 输入: "1 + 1"
     * 输出: 2
     * 示例 2:
     *
     * 输入: " 2-1 + 2 "
     * 输出: 3
     * 示例 3:
     *
     * 输入: "(1+(4+5+2)-3)+(6+8)"
     * 输出: 23
     * 说明：
     *
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     *
     * "(1+(4+5+2)-3)+(6+8)"
     *
     * @author fcz
     * @since 2020/8/4
     */
    public static int calculate2(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        // 当前操作数的值
        int operand = 0;
        // 结果值
        int result = 0;
        // 判断正负
        int sign = 1;
        char[] strChar = s.toCharArray();
        for (char ch : strChar) {
            if (Character.isDigit(ch)) {
                // 当前为数字 计算值
                operand = (10 * operand) + (ch - '0');
            } else if (ch == '+') {
                // + 保存入结果 sign为正
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (ch == '-') {
                // + 保存入结果 sign为负
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (ch == '(') {
                // 保存括号前的结果入栈
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                // 括号结束 将括号内的结果res 与括号前的值进行计算
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();

                operand = 0;
            }
        }
        return result + (sign * operand);
    }

    // 反转计算
    public int evaluateExpr(Stack<Object> stack) {

        int res = 0;

        if (!stack.empty()) {
            res = (int) stack.pop();
        }
        while (!stack.empty() && !((char) stack.peek() == ')')) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }

    public int calculate3(String s) {

        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
                n += 1;

            } else if (ch != ' ') {
                if (n != 0) {
                    stack.push(operand);
                    n = 0;
                    operand = 0;
                }
                if (ch == '(') {
                    int res = evaluateExpr(stack);
                    stack.pop();
                    stack.push(res);
                } else {
                    stack.push(ch);
                }
            }
        }
        if (n != 0) {
            stack.push(operand);
        }
        return evaluateExpr(stack);
    }

}
