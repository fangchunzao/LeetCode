package com.leetcode.train.binary_tree;

/**
 * @author FCZ
 * @since 2018/12/24 09:16
 * 每个节点的右向指针
 */
public class BinaryTree6 {

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n8 = new TreeLinkNode(8);

        n2.left=n4; n2.right=n5;
        n3.left=n6; n3.right=n7;
        n1.left=n2; n1.right=n3;

        connect(n1);
        int ss = 1;
    }

    public static void connect(TreeLinkNode root) {
        if (root == null || root.left == null || root.right == null) return;
        root.left.next = root.right;
        if (root.next != null)
            root.right.next=root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
