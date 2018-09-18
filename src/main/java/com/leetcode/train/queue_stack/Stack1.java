package com.leetcode.train.queue_stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:  最小栈
 *
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
 */

class MinStack {

    private List<Integer> data;

    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public void pop() {
        data.remove(data.size() - 1);
    }

    public int top() {
       return data.get(data.size() - 1);
    }

    public int getMin() {
        return Collections.min(data);
    }
}

public class Stack1 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }

}
