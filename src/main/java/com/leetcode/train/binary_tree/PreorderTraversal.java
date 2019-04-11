package com.leetcode.train.binary_tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FCZ
 * @since 2018/12/6 10:50
 * 前序遍历
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);

        treeNode.right = treeNode1;
        treeNode1.left = treeNode2;


        List<Integer> result = preorderTraversal(treeNode);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recurrence(root,result);
        return result;
    }

    public static void recurrence(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        recurrence(root.left,result);
        recurrence(root.right,result);
    }
}
