package com.leetcode.stock.one;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class LeetCode21 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);

        ListNode listNode01 = new ListNode(2);
        ListNode listNode02 = new ListNode(4);
        ListNode listNode03 = new ListNode(3);
        ListNode listNode04 = new ListNode(4);
        ListNode listNode05 = new ListNode(5);
        ListNode listNode06 = new ListNode(6);

        listNode1.next = listNode01;
        listNode01.next = listNode02;

        listNode2.next = listNode03;
        listNode03.next = listNode04;
        listNode04.next = listNode05;
        listNode05.next = listNode06;

        showListNode(mergeTwoLists(listNode1,listNode2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return  l1;

        ListNode resListNode = null; //待放入
        while (l1 != null && l2 != null) {
            ListNode tempNode = null;
            if (l1.val > l2.val) {
                tempNode = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                tempNode = new ListNode(l1.val);
                l1 = l1.next;
            }
            if (resListNode == null) {
                resListNode = tempNode;
            } else {
                addListNode(resListNode,tempNode);
            }
        }

        addListNode(resListNode,l1);
        addListNode(resListNode,l2);
        return resListNode;
    }

    public static void showListNode(ListNode listNode) {
        StringBuilder str = new StringBuilder();
        while (listNode != null) {
            str.append(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println( str.substring(0,str.length() - 2));
    }

    public static void addListNode(ListNode listNode, ListNode code) {
        if (code == null) return;
        ListNode node = listNode;

        while (true) {
            if (node.next == null) {
                node.next = code;
                break;
            }
            node = node.next;
        }
    }


}
