package com.leetcode.train.binary_tree;

import java.util.*;

/**
 * @author FCZ
 * @since 2018/12/14 10:27
 * 中序遍历二叉树
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

    // 迭代完成
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        // 利用一个Stack完成
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 用于判断是否已经存在
        Set<TreeNode> set = new HashSet<>();

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (!set.add(treeNode)) {  // 判断是否已经存在
                // 添加失败 即已经存在 添加入result
                result.add(treeNode.val);
                continue;
            }
            // 没有左右节点 直接将放入result
            if (treeNode.right == null && treeNode.left == null) {
                result.add(treeNode.val);
                continue;
            }
            // 将节点压入stack中 需要与与中序遍历相反 stack 先进后出

            // 右节点存在 放入右节点 到至stack
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            // 放入中节点
            stack.push(treeNode);
            // 存在左节点 放入左节点 至stack
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }

        }
        return result;
    }


}
