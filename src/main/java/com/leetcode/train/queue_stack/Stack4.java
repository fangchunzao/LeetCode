package com.leetcode.train.queue_stack;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * 逆波兰式（Reverse Polish notation，RPN，或逆波兰记法），也叫后缀表达式（将运算符写在操作数之后）
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 *
 * @author fcz
 * @since 2018/9/19 11:25
 */
public class Stack4 {

    public static void main(String[] args) {
        String[] s = {"0", "3", "/"};
        System.out.println(evalRPN1(s));
    }

    /**
     *  判断字符类型
     *  数字直接压入栈中
     *  符号 判断不同符号类型 计算后 压入栈中
     */
    public int evalRPN(String[] tokens) {
        String operator="+-*/";
        Stack<String> stack = new Stack<String>();
        for(String temp:tokens) {
            if(operator.contains(temp)){  // 当前符号为运算符
                int index=operator.indexOf(temp);
                // 取出栈顶的两个元素
                int n1=Integer.valueOf(stack.pop());
                int n2=Integer.valueOf(stack.pop());
                switch(index){  // 判断不同的操作符，执行不同的运算,运算后结果继续放入栈中，与后面的数进行计算
                    case 0: // +
                        stack.push(String.valueOf(n1+n2));
                        break;
                    case 1:  // -
                        stack.push(String.valueOf(n2-n1));
                        break;
                    case 2: // *
                        stack.push(String.valueOf(n2*n1));
                        break;
                    case 3:  // /
                        stack.push(String.valueOf(n2/n1));
                        break;
                }
            }else{  // 数字直接放入栈中
                stack.push(temp);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static int evalRPN1(String[] tokens) {
        String symbol = "+-*/";
        Stack<String> nums = new Stack<>();
        for(String str : tokens) {
            if (symbol.contains(str)) {
                int symbolIndex = symbol.indexOf(str); //判断符号类型
                Integer value1 = Integer.valueOf(nums.pop());
                Integer value2 = Integer.valueOf(nums.pop());
                switch (symbolIndex) {
                    case 0 : nums.push(String.valueOf(value1 + value2)); break;
                    case 1 : nums.push(String.valueOf(value2 - value1)); break;
                    case 2 : nums.push(String.valueOf(value1 * value2)); break;
                    case 3 : nums.push(String.valueOf(value2 / value1)); break;
                }
            } else {
                nums.push(str);
            }
        }
        return Integer.valueOf(nums.pop());
    }

}
