package com.leetcode.iv.dic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * description 面试题 03.03. 堆盘子
 *
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。
 * 请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
 * 此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
 *
 * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 *
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 *
 * 示例1:
 *
 *  输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 *  输出：
 * [null, null, null, 2, 1, -1]
 * 示例2:
 *
 *  输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, 3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stack-of-plates-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-09 16:23
 */
public class Dic03_03 {

    List<Deque<Integer>> stackList;
    int stackSize;

    public Dic03_03(int cap) {
        stackList = new ArrayList<>();
        stackSize = cap;
    }

    public void push(int val) {
        if (this.stackSize <= 0)
            return;
        boolean isCreate = false;
        if (stackList.size() == 0) {
            isCreate = true;
        } else {
            Deque<Integer> deque = stackList.get(stackList.size() - 1);
            if (deque.size() >= stackSize) {
                isCreate = true;
            } else {
                deque.push(val);
            }
        }
        if (isCreate) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(val);
            stackList.add(deque);
        }
    }

    public int pop() {
        if (stackList.size() == 0) {
            return -1;
        }
        Deque<Integer> deque = stackList.get(stackList.size() - 1);
        int value = deque.pop();
        if (deque.isEmpty()) {
            stackList.remove(deque);
        }
        return value;

    }

    public int popAt(int index) {
        if (index > stackList.size() - 1) {
            return -1;
        }
        Deque<Integer> deque = stackList.get(index);
        int value = deque.pop();
        if (deque.isEmpty()) {
            stackList.remove(deque);
        }
        return value;
    }

}
