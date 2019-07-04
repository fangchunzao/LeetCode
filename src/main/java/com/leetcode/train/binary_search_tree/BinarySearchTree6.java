package com.leetcode.train.binary_search_tree;

/**
 * Kth Largest Element in a Stream
 * @author Mr.F
 * @since 2019/7/4 09:42
 **/
public class BinarySearchTree6 {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {1,1};
        BinarySearchTree6 b = new BinarySearchTree6(k,arr);
        System.out.println(b.add(1));
        System.out.println(b.add(1));
        System.out.println(b.add(3));
        System.out.println(b.add(3));
        System.out.println(b.add(3));
        System.out.println(b.add(4));
        System.out.println(b.add(4));
        System.out.println(b.add(4));
    }

    private TreeNode root;

    private int k;


    public BinarySearchTree6(int k, int[] nums) {
        // 将数组构成一个搜索二叉树
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }


    public int add(int val) {
        if (root == null) {
            root = insertIntoBST(root,val);
        } else {
            if (root.size < k){
                root = insertIntoBST(root,val);
            }
            else if (findLeftMinNode(root).val < val) { // 最小节点
                // 删除最小节点
                root = deleteNode(root, findLeftMinNode(root).val);
                root = insertIntoBST(root, val);
            }
        }
        return findLeftMinNode(root).val;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val,1);
            return root;
        }
        if (root.val >= val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        // else root.val = val;
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    public TreeNode deleteNode(TreeNode treeNode, int value) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.val >= value && treeNode.left != null) treeNode.left = deleteNode(treeNode.left, value);
        else if (treeNode.val < value) treeNode.right = deleteNode(treeNode.right, value);
        else {
            if (treeNode.val == value) return treeNode.right;
            if (treeNode.right == null) return null;
            TreeNode node = treeNode;
            treeNode = findLeftMinNode(node.right);
            treeNode.left = node.left;
        }
        treeNode.size = size(treeNode.left) + size(treeNode.right) + 1;
        return treeNode;
    }

    // 获取最左侧的节点
    private TreeNode findLeftMinNode(TreeNode node) {
        if(node.left == null){
            return node;
        } else {
            return findLeftMinNode(node.left);
        }
    }

    private int size (TreeNode node){
        if (node == null) return 0;
        else return node.size;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int size;  // 有多少个子节点
        TreeNode(int x,int size) { this.val = x; this.size = size; }
    }

}
