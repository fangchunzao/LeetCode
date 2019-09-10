package com.leetcode.stock.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 155. 最小栈
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/10 10:56
 **/
public class LeetCode155 {

    public static void main(String[] args) {
        LeetCode155 minStack = new LeetCode155();
        minStack.push(1);
        minStack.push(-2);
        minStack.push(-1);
        minStack.push(3);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private int[] s;
    private int[] min;
    private int top;

    /** initialize your data structure here. */
    public LeetCode155() {
        s = new int[10];
        min = new int[10];
        top = -1;
    }

    public void push(int x) {
        if (top == s.length - 1) {
            // 数组扩容
            int[] temps = new int [s.length*2];
            int[] tempm = new int [s.length*2];
            for (int i = 0; i < s.length; i++){
                temps[i] = s[i];
                tempm[i] = min[i];
            }
            s = temps;
            min = tempm;
        }
        s[top+1] = x;
        if (top < 0) {
            min[top+1] = x;
        } else {
            min[top+1] = Math.min(x, min[top]);
        }
        top ++;
    }

    public void pop() {
        if (top >= 0){
            top--;
        }
    }

    public int top() {
        if (top >= 0){
            return s[top];
        }
        else {
            return -1;
        }
    }

    public int getMin() {
        return min[top];
    }

}
