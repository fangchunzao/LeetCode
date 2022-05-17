package com.leetcode.iv.offer;

import java.util.*;

/**
 * 面试题31. 栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-11 复习
 */
public class Offer31 {

    // 栈模拟
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0;i < pushed.length;i++){
            // 模拟进栈
            stack.push(pushed[i]);
            // 如果 出栈队列元素 与 当前元素 相同 就出栈  如果是一个合法的 就会全部出栈 那么最后栈是空的
            while(!stack.empty() && j < popped.length && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    // 栈模拟 复杂化了
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) return false;

        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> pushMap = new HashMap<>();
        for (int i = 0; i < pushed.length; i++)
            pushMap.put(pushed[i], i);

        int start = 0;
        for (int i = 0; i < popped.length; i++) {
            //
            Integer index = pushMap.get(popped[i]);

            for (; start <= index; start++) {
                stack.push(pushed[start]);
            }

            if (stack.pop() != popped[i]) return false;
        }
        return true;
    }

}
