package com.leetcode.iv.dic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * description 面试题 03.05. 栈排序
 *
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
 * 但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。
 * 当栈为空时，peek 返回 -1。
 *
 * 示例1:
 *
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 * 示例2:
 *
 *  输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 *  输出：
 * [null,null,null,null,null,true]
 * 说明:
 *
 * 栈中的元素数目在[0, 5000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-09 16:53
 */
public class Dic03_05 {
    // 最优解在下面

    // 使用两个栈来回转换 使deque1呈递增顺序 最小元素一直在栈顶
    Deque<Integer> deque1;
    Deque<Integer> deque2;

    public Dic03_05() {
        deque1 = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
    }

    public void push(int val) {
        boolean flag = false;
        while (!deque1.isEmpty()) {
            if (flag) {
                deque2.push(deque1.pop());
            } else {
                if (deque1.peek() < val) {
                    deque2.push(deque1.pop());
                } else {
                    deque2.push(val);
                    flag = true;
                }
            }
        }
        if (!flag) {
            deque2.push(val);
        }
        while (!deque2.isEmpty()) {
            deque1.push(deque2.pop());
        }
    }

    public void pop() {
        if (deque1.isEmpty()) {
            return;
        }
        deque1.pop();
    }

    public int peek() {
        if (deque1.isEmpty()) {
            return -1;
        }
        return deque1.peek();
    }

    public boolean isEmpty() {
        return deque1.isEmpty();
    }

}
// 利用插入的val 分割成俩个栈
// 左边存放 从上到下递增 大于val的栈
// 右边存放 从上到下递减的 小于val的
class SortedStack1 {

    // 保证 deque 是一个顺序递增的栈
    Deque<Integer> deque;
    // 保证 dequeHelp 是一个顺序递减的栈（转移到 deque 就变成了了递增的）
    Deque<Integer> dequeHelp;

    public SortedStack1() {
        deque = new ArrayDeque<>();
        dequeHelp = new ArrayDeque<>();
    }

    public void push(int val) {
        if (deque.isEmpty()) {
            deque.push(val);
        } else {
            // 元素 大于 栈顶元素（大于最小值）
            // 将小于元素的值 移到 辅助栈
            if (deque.peek() < val) {
                while (!deque.isEmpty() && deque.peek() < val) {
                    dequeHelp.push(deque.pop());
                }
                deque.push(val);
            } else if (dequeHelp.isEmpty() || dequeHelp.peek() <= val) {
                // 辅助栈为空 或者 辅助栈栈顶元素 小于 元素  直接放入
                dequeHelp.push(val);
            } else {
                // 辅助栈不为空 并且 辅助栈栈顶元素 大于 元素
                // 将大于 元素 的值 移到 栈 中
                // 保证栈存放小于 val 的元素呈递增趋势
                // 保证辅助栈存放的元素大于 val 的元素呈递减趋势
                while (!dequeHelp.isEmpty() && dequeHelp.peek() > val) {
                    deque.push(dequeHelp.pop());
                }
                dequeHelp.push(val);
            }
        }
    }

    public void pop() {
        while (!dequeHelp.isEmpty()) {
            deque.push(dequeHelp.pop());
        }
        if (!deque.isEmpty()) {
            deque.pop();
        }

    }

    public int peek() {
        while (!dequeHelp.isEmpty()) {
            deque.push(dequeHelp.pop());
        }
        return deque.isEmpty() ? -1 : deque.peek();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

}

