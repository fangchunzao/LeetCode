package com.leetcode.iv.offer;

import com.leetcode.struct.TreeNode;

/**
 * 面试题27. 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *   4
 *  /  \
 *  2   7
 * / \  / \
 * 1  3 6  9
 * 镜像输出：
 *
 *   4
 *  /  \
 *  7   2
 * / \  / \
 * 9  6 3 1
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-09 复习
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode rootNode = new TreeNode(root.val);

        TreeNode leftNode = mirrorTree(root.left);
        TreeNode rightNode = mirrorTree(root.right);

        rootNode.right = leftNode;
        rootNode.left = rightNode;
        return rootNode;

    }

}
