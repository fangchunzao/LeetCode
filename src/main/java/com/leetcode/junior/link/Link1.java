package com.leetcode.junior.link;

import java.util.List;

/**
 *  删除链表中的节点
 *  请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *  现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *  4 -> 5 -> 1 -> 9
 */

public class Link1 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        head = listNode1;
    }

    public static ListNode head = null;

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
