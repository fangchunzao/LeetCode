package com.leetcode.train.binary_tree;

import java.util.*;

/**
 * @author FCZ
 * @since 2018/12/27 10:32
 */
public class BinaryTree9 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n2.left = n4;
        n2.right = n5;
//        n3.left=n6;
        n3.right = n7;
        n1.left = n2;
        n1.right = n3;

        System.out.println();
        // 1,2,3,4,5,null,7
        String data = serialize(n1);
        TreeNode treeNode = deserialize(data);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder(); // 保存最终的结果
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return res.toString();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                res.append(cur.val + " ");
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                res.append("# ");
            }
        }
        System.out.println(res.toString().trim());
        return res.toString().trim();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] str = data.split(" ");
        TreeNode root = createTree(str);
        return root;
    }

    public static TreeNode createTree(String[] str) {
        TreeNode root = null;
        int index = 0;
        root = createTreeNode(str[index++]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = createTreeNode(str[index++]);
            node.right = createTreeNode(str[index++]);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return root;
    }

    public static TreeNode createTreeNode(String str) {
        if (str.equals("#"))
            return null;
        return new TreeNode(Integer.parseInt(str));
    }
}

