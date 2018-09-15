package com.leetcode.algorithm.junior.link;

public class Link2 {


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode listNode = LinkUtil.createListNode(a);
        LinkUtil.printListNode(listNode);
        LinkUtil.printListNode(removeNthFromEnd(listNode,5));
        LinkUtil.printListNode(listNode);
    }

    /**
     * 定义两个指针，第一个指针先走n下，然后两个指针一起走，当第一个指针走到头时，第二个指针位置即为删除位置
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        ListNode node2 = head;

        while (n > 0) {
            node1 = node1.next;
            n--;
        }

        if (node1 == null) { //说明删除位置为首位
            head = head.next;
            return head;
        }

        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;

        return head;
    }


}
