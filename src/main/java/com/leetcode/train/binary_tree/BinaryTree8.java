package com.leetcode.train.binary_tree;

/**
 * @author FCZ
 * @since 2018/12/27 10:24
 * 二叉树的最近公共祖先
 */
public class BinaryTree8 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);

        if (leftNode != null && rightNode != null) return root;
        if (leftNode == null) return rightNode;
        return leftNode;
    }

}
