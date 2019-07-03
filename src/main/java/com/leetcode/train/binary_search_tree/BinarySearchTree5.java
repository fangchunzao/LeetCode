package com.leetcode.train.binary_search_tree;

/**
 * Delete Node in a BST
 * @author Mr.F
 * @since 2019/7/3 10:59
 **/
public class BinarySearchTree5 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        } else if(key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null){
                root = root.right;
            } else if(root.right == null){
                root = root.left;
            } else {
                // root.left != null && root.right != null;
                TreeNode leftminNode = findLeftMinNode(root.right);
                root.val = leftminNode.val;
                // 删除该最小节点
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private TreeNode findLeftMinNode(TreeNode node) {
        if(node.left == null){
            return node;
        } else {
            return findLeftMinNode(node.left);
        }
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        TreeNode deleteNode = BinarySearchTree3.searchBST1(root,key);
        if (deleteNode.left == null) {
            deleteNode = deleteNode.right;
        } else if (deleteNode.right == null) {
            deleteNode = deleteNode.left;
        } else {
            deleteNode.val = findLeftMinNode(deleteNode.right).val;
            deleteNode.right = deleteNode1(deleteNode.right, deleteNode.val);
        }
        return root;
    }





}
