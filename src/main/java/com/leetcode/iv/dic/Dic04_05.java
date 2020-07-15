package com.leetcode.iv.dic;

import com.leetcode.struct.TreeNode;

/**
 * description 面试题 04.05. 合法二叉搜索树
 *
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-14 10:47
 */
public class Dic04_05 {

    // 区间递归判断
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        return isValidBST(root.left, Long.MIN_VALUE, root.val)
                && isValidBST(root.right, root.val, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        boolean left = isValidBST(root.left, min, root.val);
        boolean right = isValidBST(root.right, root.val, max);
        return left && right;
    }

}
