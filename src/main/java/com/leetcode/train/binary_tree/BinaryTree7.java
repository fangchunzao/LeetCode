package com.leetcode.train.binary_tree;

/**
 * @author FCZ
 * @since 2018/12/27 09:33
 * 每个节点的右向指针 II
 */
public class BinaryTree7 {

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(2);
        TreeLinkNode n2 = new TreeLinkNode(1);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(0);
        TreeLinkNode n5 = new TreeLinkNode(7);
        TreeLinkNode n6 = new TreeLinkNode(9);
        TreeLinkNode n7 = new TreeLinkNode(1);
        TreeLinkNode n8 = new TreeLinkNode(2);
        TreeLinkNode n9 = new TreeLinkNode(1);
        TreeLinkNode n10 = new TreeLinkNode(0);
        TreeLinkNode n11 = new TreeLinkNode(8);
        TreeLinkNode n12 = new TreeLinkNode(8);

       n2.left = n4; n2.right = n5;
       n3.left = n6; n3.right = n7;
       n4.left= n8;
       n5.left = n9; n5.right = n10;
       n7.left = n11; n7.right = n12;
       n1.left=n2; n1.right=n3;

        connect(n1);
    }

    public static void connect(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.left != null)
            root.left.next = root.right;
        TreeLinkNode nextNode = root.next;
        while (nextNode != null){
            if (nextNode.left == null && nextNode.right == null) {
                nextNode = nextNode.next;
                continue;
            }
            TreeLinkNode leftNode = null;
            if (root.left != null)
                leftNode = root.left;
            if (root.right != null)
                leftNode = root.right;
            TreeLinkNode rightNode = null;
            if(nextNode.right != null)
                rightNode =nextNode.right;
            if (nextNode.left != null)
                rightNode =nextNode.left;
            leftNode.next = rightNode;
            break;
        }
        connect(root.right);
        connect(root.left);

    }

}
