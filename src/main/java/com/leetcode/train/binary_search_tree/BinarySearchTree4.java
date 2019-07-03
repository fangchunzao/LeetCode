package com.leetcode.train.binary_search_tree;

/**
 * Insert into a Binary Search Tree
 * @author Mr.F
 * @since 2019/7/3 10:36
 **/
public class BinarySearchTree4 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);

        TreeNode treeNode = insertIntoBST(treeNode1, 2);
        treeNode = insertIntoBST(treeNode1, 3);
        treeNode = insertIntoBST(treeNode1, 4);
        treeNode = insertIntoBST(treeNode1, 5);
        treeNode = insertIntoBST(treeNode1, 6);
        treeNode = insertIntoBST(treeNode1, 7);
        treeNode = insertIntoBST(treeNode1, 8);
        treeNode = insertIntoBST(treeNode1, 9);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            }
            if (node.val < val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }
                node = node.right;
            }
        }
        return root;
    }

}
