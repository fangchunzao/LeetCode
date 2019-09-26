package com.leetcode.stock.one;

/**
 * 链表节点
 *
 * @author Mr.F
 * @since 2019/9/26 09:31
 **/
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

}
