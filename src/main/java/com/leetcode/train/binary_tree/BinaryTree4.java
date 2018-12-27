package com.leetcode.train.binary_tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FCZ
 * @since 2018/12/24 09:16
 * 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 */
public class BinaryTree4 {

    public static void main(String[] args) {
        int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        TreeNode treeNode = buildTree(inOrder,postOrder);
        int a = 0;
    }

    /**
     * 后序遍历序列的最后一个元素一定是该树的根节点，因而从此入手，
     * 在中序遍历序列中找到该元素，其左所有元素都是以该元素为根节点的左子树的节点，
     * 其右所有元素都是以该元素为根节点的右子树的节点，
     * 可在此将两边分为左子树和右子树的中序遍历子序列两个新的数组。
     *
     * 同时，后序遍历序列中根节点之后的节点都是先把左子树节点遍历完毕才遍历右子树节点的，
     * 因此可以根据中序遍历序列中左子树节点的数量，找到所有属于左子树和右子树的元素
     * ，并分为两个新的后序遍历子序列数组。
     * 然后利用递归分别对左右子树的后序和中序序列进行处理，如果序列为空则返回null，
     * 如果序列只有一个值则可判断为叶子节点，返回当前节点。最终可得到一个完整的二叉树。
     * @param inorder
     * @param postorder
     * @return
     */

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0
        || postorder == null || postorder.length == 0) return null;
        return buildTree(inorder,0,inorder.length - 1, postorder,0,postorder.length - 1);
    }

    public static TreeNode buildTree(int[] a, int a1, int a2, int[] b, int b1, int b2) {
        if (a1 > a2 || b1 > b2) return null;
        // 后序遍历的尾节点 一定为当前的根节点
        int rootNode = b[b2];
        // 从中序遍历中找到该节点的位置
        int inPos = getArrayIndex(a,rootNode);
        // 中序数组按照根节点位置分割为左子树数组与右子树数组
        // 后序数组按照 上一步分割的数组个数 分割为左子树与右子树
        // 计算的出 中序数组 左子树数组的个数
        int splitCount = inPos - a1;
        // 根节点
        TreeNode treeNode = new TreeNode(b[b2]);
        // 分割 递归遍历
        treeNode.left = buildTree(a, a1, inPos - 1, b, b1, b1 + splitCount - 1);
        treeNode.right = buildTree(a,inPos + 1, a2, b, b1 + splitCount, b2 - 1);
        return treeNode;
    }

    private static int getArrayIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) { return null; }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree1(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree1(int[] a, int a1, int a2, int[] b, int b1, int b2) {
        if (a1 > a2 || b1 > b2) { return null; }
        // 找到中序遍历中的位置
        int mid = map.get(b[b2]);
        // 存在多少个左子树节点
        int count = mid - a1;
        TreeNode root = new TreeNode(b[b2]);
        // 左子树
        root.left = buildTree1(a, a1, mid - 1, b, b1, b1 + count - 1);
        // 右子树
        root.right = buildTree1(a, mid + 1, a2, b, b1 + count, b2 - 1);
        return root;
    }
}
