package com.leetcode.train.queue_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: FCZ
 * @Description:
 * @Date: 2018/9/18 11:17
 */
public class Stack2 {


    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> charMap = new HashMap<Character, Character>() {{
            put('}','{'); put(']','['); put(')','(');
        }};
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            if (charMap.containsKey(s.charAt(i))) {
                if (stack.empty() || stack.pop() != charMap.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
