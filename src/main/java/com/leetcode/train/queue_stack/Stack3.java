package com.leetcode.train.queue_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 * @author fcz
 */
public class Stack3 {

    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }

    /**
     * 将下标放入栈中，如果温度升高，计算下标差。
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.empty() && temperatures[stack.peek()] < temp) {
                // 升温
                int stackTempIndex = stack.pop();
                int waitDay = i - stackTempIndex;
                res[stackTempIndex] = waitDay;
            }
            stack.push(i);  // 放入栈中的是下标
        }
        return res;
    }


}
