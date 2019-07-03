package com.leetcode.train.binary_search_tree;

/**
 * Search in a Binary Search Tree
 * @author Mr.F
 * @since 2019/7/3 10:07
 **/
public class BinarySearchTree3 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(20);
        TreeNode treeNode6 = new TreeNode(12);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left=treeNode4;
        treeNode3.right=treeNode5;
        treeNode5.left = treeNode6;
        treeNode6.right=treeNode7;
        treeNode1.left = treeNode2;

        System.out.println(searchBST(treeNode1, 12).val);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        TreeNode left = searchBST(root.left,val);
        TreeNode right = searchBST(root.right, val);
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

    public static TreeNode searchBST1(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        TreeNode node = null;
        if(root.val > val)
            node = searchBST(root.left,val);
        if(root.val < val)
            node = searchBST(root.right,val);
        return node;
    }

}
