package com.leetcode.train.binary_tree;

/**
 * @author FCZ
 * @since 2018/12/21 11:12
 */
public class BinaryTree3 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(1);

        treeNode4.left = treeNode7;
        treeNode4.right=treeNode8;
        treeNode6.right = treeNode9;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        System.out.println(hasPathSum(treeNode1,22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return sum(root,0,sum);
    }

    public static boolean sum(TreeNode root, int value, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && value + root.val == sum) {
            return true;
        }

        boolean flag1 = sum(root.left,value +  root.val,sum);
        boolean flag2 = sum(root.right,value +  root.val,sum);
        return flag1 || flag2;
    }
}
