package com.leetcode.train.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FCZ
 * @since 2018/12/24 09:16
 */
public class BinaryTree5 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder,inorder);
        int ss = 0;
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0
                || preorder == null || preorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder,0,inorder.length - 1, preorder,0,preorder.length - 1);
    }

    public static TreeNode buildTree(int[] a, int a1, int a2, int[] b, int b1, int b2) {
        if (a1 > a2 || b1 > b2) return null;
        // 前序遍历的首元素 一定是根节点
        int prePos = map.get(b[b1]);
        // 中序遍历中 左子树的节点个数
        int splitCount = prePos - a1;
        //
        TreeNode treeNode = new TreeNode(b[b1]);
        treeNode.left = buildTree(a,a1,prePos - 1,b, b1 + 1, b1 + splitCount);
        treeNode.right = buildTree(a, prePos + 1, a2, b, b1 + splitCount + 1, b2);
        return treeNode;
    }

}
