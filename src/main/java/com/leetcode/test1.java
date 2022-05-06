package com.leetcode;

import com.leetcode.struct.ListNode;

import java.util.*;

public class test1 {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5\
        // 1 ->
        // 4 -> 3 -> 2
        // 5
        int m = 1, n = 4;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode startNode = node1;
        ListNode startPreNode = null;
        for (int i = 1; i < m; i++) {
            startPreNode = startNode;
            startNode = startNode.next;
        }

        ListNode endNode = startNode;

        // 从start进行反转
        ListNode tempPre = null;
        for (int i = m; i <= n; i++) {
            ListNode tempNode = endNode.next;
            endNode.next = tempPre;
            tempPre = endNode;
            endNode = tempNode;
        }
        // 1 -> null
        // 4 -> 3 -> 2 -> null
        // 4 -> 5
        if (startPreNode != null)
            startPreNode.next = tempPre;
        else
            node1 = tempPre;
        startNode.next = endNode;
        int i = 0;
        Set<String> map = new HashSet<>();

    }

}
