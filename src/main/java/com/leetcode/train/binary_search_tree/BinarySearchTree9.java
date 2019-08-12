package com.leetcode.train.binary_search_tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * @author Mr.F
 * @since 2019/8/12 10:16
 **/
public class BinarySearchTree9 {

    boolean flag=true;

    public boolean isBalanced(TreeNode root) {
        treeHigh(root);
        return flag;
    }

    int treeHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeHigh(root.left);
        int right = treeHigh(root.right);

        if (Math.abs(left - right) > 1 ){
            flag = false;
        }
        return 1 + Math.max(left, right);
    }
}
