package com.leetcode.iv.dic;

/**
 * description 面试题 03.01. 三合一
 *
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-07 09:25
 */
public class Dic03_01 {

    private int[] stack;
    private int stackSize;

    public Dic03_01(int stackSize) {
        // 多出3个空间存放每个栈的空间大小
        stack = new int[3 + stackSize * 3];
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        // 当前栈的容量 等于 栈容量
        if (stack[stackNum] == this.stackSize) {
            return;
        }
        stack[stackLastIndex(stackNum, stack[stackNum]++)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return stack[stackLastIndex(stackNum, --stack[stackNum])];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return stack[stackLastIndex(stackNum, stack[stackNum] - 1)];
    }

    public boolean isEmpty(int stackNum) {
        return stack[stackNum] == 0;
    }

    /**
     * description 获取当前栈最后一个元素的下标
     * @param stackNum 栈下标
     * @param index 该栈当前元素的数量
     * @return
     * @author fcz
     * @since 2020/7/7
     */
    private int stackLastIndex(int stackNum, int index) {
        // 前三个是栈下标的当前元素数量
        // stackNum 栈下标
        // this.stackSize 栈大小
        // index 栈当前元素数量
        return 3 + stackNum * this.stackSize + index;
    }

}
