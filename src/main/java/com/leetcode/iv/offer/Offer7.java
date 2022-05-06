package com.leetcode.iv.offer;

import com.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer7 {

    public static void main(String[] args) {
        Offer7 obj = new Offer7();
        obj.buildTree(new int[] {3,9,20,15,7},
                new int[] {9,3,15,20,7}
                );
    }

    /**
     *  二叉树的前序遍历顺序是：根节点、左子树、右子树，每个子树的遍历顺序同样满足前序遍历顺序。
     *
     * 二叉树的中序遍历顺序是：左子树、根节点、右子树，每个子树的遍历顺序同样满足中序遍历顺序。
     *
     * 1. 前序遍历的首个元素即为根节点 root 的值；
     * 2. 在中序遍历中搜索根节点 root 的索引 ，可将中序遍历划分为 [ 左子树 | 根节点 | 右子树 ] 。
     * 3. 根据中序遍历中的左（右）子树的节点数量，可将前序遍历划分为 [ 根节点 | 左子树 | 右子树 ] 。
     *
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        // 存放中序遍历 元素-位置关系
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return  buildTree(preorder, 0, length - 1, inorder, 0,
                length - 1, indexMap);
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart,
                              int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        // 通过前序遍历 获取根节点 首位就是
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        // 结束
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            // 获取中序遍历中 根节点的位置 左边就是左子树 右边是右子树
            int rootIndex = indexMap.get(rootVal);
            // 分别计算个数用于 分割前序遍历 leftNode数量就是前序遍历的左子树 rightNodes数量就是前序遍历的右子树
            int leftNodes = rootIndex - inorderStart,
                    rightNodes = inorderEnd - rootIndex;

            // 构建左子树
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes,
                    inorder, inorderStart, rootIndex - 1, indexMap);
            // 构建右子树
            System.out.println(preorderStart + leftNodes + 1);
            System.out.println(preorderEnd - rightNodes + 1);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd,
                    inorder, rootIndex + 1, inorderEnd, indexMap);

            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }

    // 手写一下上面的步骤
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree1(preorder, 0, preorder.length - 1, inorderMap, 0, inorder.length);
    }

    public TreeNode buildTree1(int[] preorder, int preorderStart, int preorderEnd,
                               Map<Integer, Integer> inorderMap, int inorderStart, int inorderEnd) {
        if (preorderStart < preorderEnd)
           return null;
        int rootValue = preorder[preorderStart];
        TreeNode rootNode = new TreeNode(rootValue);

        if (preorderStart == preorderEnd) return rootNode;
        else {
            int inorderRootIndex = inorderMap.get(rootValue);
            int leftNodeIndex = inorderStart + inorderRootIndex;
            int rightNodeIndex = inorderEnd - inorderRootIndex;

            TreeNode leftNode = buildTree1(preorder, preorderStart + 1, preorderStart + leftNodeIndex,
                    inorderMap, inorderStart, inorderRootIndex - 1);

            TreeNode rightNode = buildTree1(preorder, preorderEnd - rightNodeIndex + 1, preorderEnd,
                    inorderMap, inorderRootIndex + 1, inorderEnd);

            rootNode.left = leftNode;
            rootNode.right = rightNode;

            return rootNode;
        }
    }


}
