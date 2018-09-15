package com.leetcode.junior.link;

public class LinkUtil {

    public static ListNode createListNode(int[] a) {
        ListNode listNode = new ListNode(a[0]);  //链表头

        for (int i = 1; i < a.length; i++) {
            ListNode insertNode = new ListNode(a[i]); // 待加入节点

            ListNode cloneNode = listNode;
            while (cloneNode.next != null) {
                cloneNode = cloneNode.next;
            }
            cloneNode.next = insertNode;
        }
        return listNode;
    }

    public static void printListNode(ListNode listNode) {
        if (listNode == null) return;

        System.out.print(listNode.val);
        listNode = listNode.next;

        while (listNode != null) {
            System.out.print(" -> " + listNode.val);
            listNode =listNode.next;
        }
        System.out.println();
    }
}
