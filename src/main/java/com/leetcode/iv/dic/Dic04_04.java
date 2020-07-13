package com.leetcode.iv.dic;

import com.leetcode.struct.TreeNode;

/**
 * description 面试题 04.04. 检查平衡性
 *
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-13 21:01:45
 */
public class Dic04_04 {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return !(isBalanced(root, 1) == -1);
    }

    public int isBalanced(TreeNode root, int level) {
        if (root == null)
            return level;

        int left = isBalanced(root.left, level+1);
        int right = isBalanced(root.right, level+1);

        if (left == -1 || right == -1) {
            return -1;
        }
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }

}
