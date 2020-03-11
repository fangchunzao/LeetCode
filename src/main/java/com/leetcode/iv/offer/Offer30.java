package com.leetcode.iv.offer;

import java.util.Stack;

/**
 * 面试题30. 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer30 {

    public static void main(String[] args) {

        Offer30 obj = new Offer30();
        obj.push(10);
        obj.push(-10);
        obj.push(-5);
        System.out.println(obj.min());
        System.out.println(obj.min());
        System.out.println(obj.min());
    }

    Stack<Integer> stack1, stack2;

    public Offer30() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
        // 保证栈B的顶部放的是当前最小的数
        // 这样 stack2 存放的某个元素。在 stack1 的位置为 index, 那么可以保证在index之前，当前元素就是最小的
        if(stack2.empty() || stack2.peek() >= x)
            stack2.add(x);
    }

    public void pop() {
        // 当stack1 出栈的元素 与 stack2 出栈元素相同，stack2也需要出栈
        if(stack1.pop().equals(stack2.peek()))
            stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

}
