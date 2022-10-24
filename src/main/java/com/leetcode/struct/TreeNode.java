package com.leetcode.struct;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TreeNode {

    public     int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode newListNode(Integer[] args) {
        int index = 0;

        TreeNode root = new TreeNode(args[index++]);
        Deque<TreeNode> treeDeque = new ArrayDeque<>();
        treeDeque.offer(root);

        while (index < args.length) {
            int size = treeDeque.size();
            while (!treeDeque.isEmpty() && size-- > 0 && index < args.length) {
                TreeNode node = treeDeque.poll();
                if (index < args.length) {
                    node.left = createNode(args[index++]);
                }
                if (index < args.length) {
                    node.right = createNode(args[index++]);
                }

                if (node.left != null) {
                    treeDeque.offer(node.left);
                }
                if (node.right != null) {
                    treeDeque.offer(node.right);
                }
            }
        }
        return root;
    }

    private static TreeNode createNode(Integer num) {
        if (num == null) {
            return null;
        }
        return new TreeNode(num);
    }

}
