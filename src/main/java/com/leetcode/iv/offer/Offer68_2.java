package com.leetcode.iv.offer;

import com.leetcode.struct.TreeNode;

/**
 * description  面试题68 - II. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q
 * 最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *               3
 *             /   \
 *           [5]   [1]
 *         /  \   /  \
 *        6   2  0    8
 *           / \
 *          7  4
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-06-16 15:29
 *
 * @since 2020-08-25 复习
 **/
public class Offer68_2 {

    /**
     * 对二叉树进行遍历 找出p节点与q节点
     * 判断p、q是否不在同一侧 即为公共节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 遍历左右子树
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        // 判断条件
        // 1. 左右都为null 不存在公共节点
        if (leftNode == null && rightNode == null) {
            return null;
        }
        // 2. 左为null 右不为null 返回右
        if (leftNode == null) {
            return rightNode;
        }
        // 3. 右为null 左不为null  返回左
        if (rightNode == null) {
            return leftNode;
        }
        // 4. 左右都不为null 该节点就是公共节点
        return root;
    }

















/*    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // left 与 right都为空 左右子树都不包含 返回 null
        if(left == null && right == null)
            return null;

        if(left == null)
            return right;

        if(right == null)
            return left;
        // left 与 right都不为空 为公共节点
        return root;
    }*/


}
