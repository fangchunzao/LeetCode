package com.leetcode.iv.offer;

import com.leetcode.struct.TreeNode;

/**
 * 面试题28. 对称的二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 *          1
 *          / \
 *     2          2
 *    / \         / \
 *   3    4     4   3
 *  / \   / \   / \   / \
 * 5   6 6   5 7   6 6   7
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *
 *   1
 *  / \
 *  2  2
 * / \ / \
 * 3 4 4 3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *   1
 *  / \
 *  2  2
 *  \  \
 *  3  3
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-09 复习
 *
 */
public class Offer28 {

    // 从根节点分为左右两个几点
    // 左子树的左节点 = 右子树的右节点
    // 左子树的右节点 = 右子树的左节点
    // 递归判断 就完事了

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return true;

        if (rightTree == null || leftTree == null) return false;

        if (leftTree.val != rightTree.val) return false;

        return isSymmetric(leftTree.left, rightTree.right) && isSymmetric(leftTree.right, rightTree.left);

    }


}
