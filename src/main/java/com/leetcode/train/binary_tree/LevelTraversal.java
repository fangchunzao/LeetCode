package com.leetcode.train.binary_tree;

import java.util.*;

/**
 * @author FCZ
 * @since 2018/12/14 15:01
 */
public class LevelTraversal {

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

        List<List<Integer>> list = levelOrder(treeNode);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.poll();
                item.add(treeNode.val);
                if (treeNode.left != null)
                    queue.offer(treeNode.left);
                if (treeNode.right != null)
                    queue.offer(treeNode.right);
            }
            result.add(item);
        }
        return result;
    }
}
