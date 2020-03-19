package com.leetcode.iv.offer;

/**
 * @author fcz
 * @description 面试题36. 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 * @date 2020-03-19 11:10
 **/
public class Offer36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public static void main(String[] args) {

    }

    Node preNode, head;

    // 使用中序遍历 借助preNode保存上一个节点
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        process(root);
        head.left = preNode;
        preNode.right = head;
        return head;
    }

    public void process(Node root) {
        if (root == null) return;

        process(root.left);

        if (preNode == null) {
            // 最左边位置 初始化头结点
            head = root;
        } else {
            preNode.right = root;
        }
        root.left = preNode;

        preNode = root;
        process(root.right);
    }



}
