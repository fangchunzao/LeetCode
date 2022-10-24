package com.leetcode.struct;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode newListNode(int[] args) {
        ListNode head = new ListNode(args[0]);
        ListNode tempNode = head;
        for (int i = 1; i < args.length; i++) {
            tempNode.next =  new ListNode(args[i]);
            tempNode = tempNode.next;
        }
        return head;
    }

    public static ListNode newCircleListNode(int[] args, int pos) {

        int cnt = 1;
        ListNode head = new ListNode(args[0]);
        ListNode tempNode = head;
        ListNode circleNode = null;
        for (int i = 1; i < args.length; i++) {
            ListNode node = new ListNode(args[i]);
            if (cnt == pos) {
                circleNode = node;
            }
            if(i == args.length - 1) {
                node.next = circleNode;
                if (pos == 0) {
                    node.next = head;
                }
            }
            tempNode.next = node;
            tempNode = tempNode.next;
            cnt++;
        }


        return head;
    }

}
