package com.leetcode.train.binary_search_tree;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author FCZ
 * @since 2019/4/11 15:38
 * 二叉搜索树迭代器
 */
public class BinarySearchTree2 {

    Queue<Integer> queue = new PriorityQueue<>();
//    Stack<Integer> stack = new Stack();
    // 中序遍历
    public BinarySearchTree2(TreeNode root) {
        LDT(root);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.size() > 0;
    }

    private void LDT(TreeNode root) {
        if (root == null) return;
        LDT(root.left);
        queue.add(root.val);
        LDT(root.right);
    }

}
// 优解
class BinarySearchTree2Better{

    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curNode;

    public BinarySearchTree2Better(TreeNode root) {
        // 用栈模拟中序遍历
        curNode = root;
        // 将左节点全部放入栈中
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        // 当前curNode 为最左侧节点 即最小值
        curNode = stack.pop();
        // 如果这个节点有右节点，就把这个孩子放入栈内，然后把这个节点的左节点全部放入
        TreeNode tempNode = curNode.right;
        while (tempNode != null) {
            stack.push(tempNode);
            tempNode = tempNode.left;
        }
        return curNode.val;
        // 如果这个节点没有孩子
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        // 保证每次取出一个孩子都把栈恢复为原来的状态
        if (stack.size() == 0) {
            return false;
        }
        return true;
    }
}
