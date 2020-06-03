package com.leetcode.iv.offer;

import com.leetcode.struct.ListNode;

import java.util.Stack;

/**

 * description 面试题52. 两个链表的第一个公共节点
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-06-03 10:02
 **/
public class Offer52 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;

        getIntersectionNode(node1, node4);
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }

    /**
     * 双指针
     * L指针从链表A开始  R指针从链表B开始  到达末尾 L再从B开始  R从A开始
     * 当L == R时 相交
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode L = headA;
        ListNode R = headB;
        // 当一个节点达到一个链表的尾部，则从另一个链表继续
        while (L != R) {
            L = L == null ? headB : L.next;
            R = R == null ? headA : R.next;
        }
        return L;
    }

}
