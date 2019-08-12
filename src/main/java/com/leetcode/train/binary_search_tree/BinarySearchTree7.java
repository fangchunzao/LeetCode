package com.leetcode.train.binary_search_tree;

/**
 * 二叉搜索树的最近公共祖先
 * @author Mr.F
 * @since 2019/8/12 09:29
 **/
public class BinarySearchTree7 {

    public static void main(String[] args) {

    }

    // 从上到下按层查找 当pq节点不在同一侧时，即为公共节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        while(root != null){
            if(p.val > root.val && q.val > root.val){
                //p.q都大于root 都在右子树
                root = root.right;
            } else if (p.val < root.val && q.val < root.val){
                //p.q都小于root 都在左子树
                root = root.left;
            }
            else
                return root;
        }
        return null;
    }

}
