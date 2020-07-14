package com.leetcode.iv.dic;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * description 面试题 04.12. 求和路径
 *
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 *
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
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
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-14 15:44
 */
public class Dic04_12 {

    // 使用List保存路径 每一次判断是否与target相同
    public int pathSum(TreeNode root, int sum) {
        pathSum(root, new ArrayList<>(), sum);
        return count;
    }

    int count = 0;
    public void pathSum(TreeNode root, List<Integer> list, int target) {
        if (root == null)
            return;
        list.add(root.val);

        int temp = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            temp += list.get(i);
            if (temp == target)
                count++;
        }

        pathSum(root.left, list, target);
        pathSum(root.right, list, target);

        list.remove(list.size() - 1);

    }

    // 原题题解
    // 计算层高 使用数组计算
    public int pathSum1(TreeNode root, int sum) {
        int dep = depth(root);
        int[] paths = new int[dep];
        pathSum(root, sum, 0, paths);
        return res;
    }

    int res = 0;

    public void pathSum(TreeNode root, int sum, int level, int[] paths) {
        if (root == null) {
            return;
        }
        paths[level] = root.val;
        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += paths[i];
            if (t == sum) {
                res += 1;
            }
        }
        pathSum(root.left, sum, level + 1, paths);
        pathSum(root.right, sum, level + 1, paths);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

}
