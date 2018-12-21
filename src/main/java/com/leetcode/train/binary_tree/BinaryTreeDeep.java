package com.leetcode.train.binary_tree;

/**
 * @author FCZ
 * @since 2018/12/21 10:03
 * 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 * 返回它的最大深度 3 。
 */
public class BinaryTreeDeep {

    private static int answer;

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        deep(treeNode1,1);
        System.out.println(answer);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth) +  1;
    }

    public static void deep(TreeNode root,int depth) {
        if (root == null) return;
        if (root.left == null  && root.right == null) {
            answer = Math.max(answer,depth);
        }
        deep(root.left, depth + 1 );
        deep(root.right, depth + 1);
    }

}
