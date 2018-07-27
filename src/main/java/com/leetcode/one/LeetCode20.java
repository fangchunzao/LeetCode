package com.leetcode.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *  有效的括号
 *
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 通过栈来解决 左括号入栈，有括号出栈。
 */
public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(isValid1("}"));
    }
    public static boolean isValid1(String s) {
        Map<Character,Character> charMap = new HashMap<Character, Character>() {{
           put('}','{'); put(']','['); put(')','(');
        }};
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsValue(s.charAt(i))) { // 左括号入栈
                stack.push(s.charAt(i));
            }
            if (charMap.containsKey(s.charAt(i))) {
                // stack.empty() 说明字符串中不存在左括号 只有右括号
                // 栈弹出的符号 与当前符号不对应 不符合条件
                if (stack.empty() || stack.pop() != charMap.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }











    public static boolean isValid(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('}', '{');
        charMap.put(']', '[');
        charMap.put(')', '(');
        char [] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsValue(s.charAt(i))) {
                stack[++top] = s.charAt(i);
            }
            if (charMap.containsKey(s.charAt(i))) {
                if (top == -1 || stack[top--] != charMap.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return top == -1;
    }
}
