package com.leetcode.train.binary_tree;

import java.util.Stack;

/**
 * @author FCZ
 * @since 2018/12/21 10:19
 * 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class BinaryTree2 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(3);

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
        System.out.println(isSymmetric1(treeNode1));

    }

    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        // 左右节点为空的情况
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        if (root.left.val != root.right.val) {
            return false;
        }
        stackLeft.push(root.left);
        stackRight.push(root.right);

        while (!stackLeft.isEmpty() && !stackRight.isEmpty()) {
            TreeNode leftRoot = stackLeft.pop();
            TreeNode rightRoot = stackRight.pop();
            TreeNode leftChildLeft = leftRoot.left;
            TreeNode leftChildRight = leftRoot.right;
            TreeNode rightChileLeft = rightRoot.left;
            TreeNode rightChileRight = rightRoot.right;
            // 判断
            if ((leftChildLeft == null ? null :leftChildLeft.val) != (rightChileRight == null ? null :rightChileRight.val))
                return false;
            if ((leftChildRight == null ? null :leftChildRight.val) != (rightChileLeft == null ? null : rightChileLeft.val))
                return false;

            if (leftChildRight != null)
                stackLeft.push(leftChildRight);
            if (leftChildLeft != null)
                stackLeft.push(leftChildLeft);
            if (rightChileLeft != null)
                stackRight.push(rightChileLeft);
            if (rightChileRight != null)
                stackRight.push(rightChileRight);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && judge(t1.left, t2.right) && judge(t1.right, t2.left);
    }
}
