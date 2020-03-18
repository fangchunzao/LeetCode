package com.leetcode.iv.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题35. 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class Offer35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }

    Map<Node, Node> map = new HashMap();

    // 使用哈希表 保存每一个节点对应的 copy节点
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node ptr = head;
        while(ptr != null) {
            Node node = getNode(ptr);
            node.next = getNode(ptr.next);
            node.random = getNode(ptr.random);
            ptr = ptr.next;
        }
        return getNode(head);

    }

    private Node getNode(Node node) {
        if (node == null) return null;

        if (!map.containsKey(node)) {
            // 不存在node 构造一个新的node
            Node tmp = new Node(node.val);
            map.put(node, tmp);
        }
        return map.get(node);
    }

}
