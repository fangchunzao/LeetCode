package com.leetcode.train.binary_search_tree;

/**
 * @author FCZ
 * @since 2019/4/11 11:09
 * 验证二叉搜索树
 */
public class BinarySearchTree1 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
/*        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(20);
        TreeNode treeNode6 = new TreeNode(12);*/
//        TreeNode treeNode7 = new TreeNode(7);

/*        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left=treeNode4;
        treeNode3.right=treeNode5;
        treeNode5.left = treeNode6;*/
    /*    treeNode6.right=treeNode7;
        treeNode1.left = treeNode2;*/
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(isValidBST(treeNode1));

    }
    static double last = -Double.MAX_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }


}
