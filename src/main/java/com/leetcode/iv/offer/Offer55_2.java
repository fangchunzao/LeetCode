package com.leetcode.iv.offer;

import com.leetcode.struct.TreeNode;

import java.util.Stack;

/**
 * description 面试题55 - II. 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since  2020-06-04 10:27
 **/
public class Offer55_2 {

    /**
     * 递归判断
     *
     * 依次判断每一个节点的左右子树的深度
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        // 计算左右子树的深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) <= 1) {
            boolean left = isBalanced(root.left);
            boolean right = isBalanced(root.right);
            return left && right;
        }
        return false;
    }

    // 递归的简化写法
    public boolean isBalanced1(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced1(root.left)
                && isBalanced1(root.right);
    }


    // 使用栈来层序遍历 判断每一个节点的左右子树深度
    public boolean isBalanced2(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int stackHigh = stack.size();
            for (int i = 0; i < stackHigh ; i++) {
                TreeNode node = stack.pop();
                int leftDepth = maxDepth(node.left);
                int rightDepth = maxDepth(node.right);
                if( Math.abs(leftDepth - rightDepth) > 1) {
                    return false;
                }
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
        }
        return true;
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }




}

