package com.leetcode.iv.offer;

import com.leetcode.struct.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer6 {

    public static void main(String[] args) {

    }

    // 递归法 使用java不太合适
    public int[] reversePrint(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        reversePrint(head, list);

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).val;
        }
        return result;
    }

    public void reversePrint(ListNode head, List<ListNode> list) {
        if (head == null) return;
        reversePrint(head.next, list);
        list.add(head);
    }

    // 使用栈辅助 栈 先进后出
    // 依次放入  弹出后就是反序的
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.empty()) {
            result[index++] = stack.pop();
        }
        return result;
    }

    // 先遍历一遍链表 计算长度
    // 重新遍历链表 由于已经知道长度 倒过来放入数组 即可
    public int[] reversePrint2(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        int[] arr = new int[count];
        node=head;
        for (int i = count-1; i >=0 ;i--) {
            arr[i] = node.val;
            node=node.next;
        }
        return arr;
    }


}
