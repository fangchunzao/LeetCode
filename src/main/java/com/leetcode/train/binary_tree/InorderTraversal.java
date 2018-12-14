package com.leetcode.train.binary_tree;

import java.util.*;

/**
 * @author FCZ
 * @since 2018/12/14 10:27
 */
public class InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        List<Integer> result = inorderTraversal(null);
            System.out.println(Arrays.toString(result.toArray()));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (!set.add(treeNode)) {
                result.add(treeNode.val);
                continue;
            }
            // 尾节点
            if (treeNode.right == null && treeNode.left == null) {
                result.add(treeNode.val);
                continue;
            }
            // 右节点
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            // 中节点
            stack.push(treeNode);
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }

        }
        return result;
    }


}
