package com.leetcode.start;


import com.leetcode.struct.TreeNode;

/**
 * description
 *
 * @author fcz
 * @since 2020-08-06 17:12
 */
public class 验证二叉搜索树 {

    // 二叉搜索树 中序遍历时为升序
    // 可以通过中序遍历 判断与上一个节点的大小 验证
    int preValue = Integer.MIN_VALUE;
    public  boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 中序遍历
        // 左节点
        if (isValidBST(root.left)) {
            // 当前节点判断
            if (preValue < root.val) {
                preValue = root.val;
                // 右节点判断
                return isValidBST(root.right);
            }
        }
        return false;
    }

}
