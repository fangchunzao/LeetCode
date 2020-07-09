package com.leetcode.iv.dic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * description 面试题 03.02. 栈的最小值
 *
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，
 * 该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 *
 * 示例：
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
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-07 10:08
 */
public class Dic03_02 {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            deque.push(i);
        }
        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pop());

        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.offer(1);
        deque2.offer(2);
        deque2.offer(3);
        System.out.println(deque2.poll());
    }

    Deque<Integer> deque = new ArrayDeque<>();
    Deque<Integer> dequeMin = new ArrayDeque<>();

    /** initialize your data structure here. */
    public Dic03_02() {
    }

    public void push(int x) {
        deque.push(x);
        if (dequeMin.isEmpty() || dequeMin.peek() > x) {
            dequeMin.push(x);
        }
    }

    public void pop() {
        int value = deque.pop();
        if (!dequeMin.isEmpty() && value == dequeMin.peek()) {
            dequeMin.pop();
        }
    }

    public int top() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public int getMin() {
        return dequeMin.isEmpty() ? -1 : dequeMin.peek();
    }

}
