package com.leetcode.iv.offer;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题34. 二叉树中和为某一值的路径
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到[叶节点]所经过的节点形成一条路径。
 *
 *
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class Offer34 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, 0, new ArrayList<>(), result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, int tempSum, List<Integer> list,List<List<Integer>> result) {
        if (root == null) return;

        tempSum += root.val;
        list.add(root.val);
        // 必须是子节点
        if (sum == tempSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        pathSum(root.left, sum, tempSum, list, result);
        pathSum(root.right, sum, tempSum, list, result);

        list.remove(list.size() - 1);

    }

}
