package com.leetcode.stock.one;

import com.leetcode.struct.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCode543 {

    public static void main(String[] args) {
    }

// [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
    public int diameterOfBinaryTree(TreeNode root) {

        diameterOfBinaryTree1(root);
        return maxValue;
    }

    private int maxValue = Integer.MIN_VALUE;

    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null)
            return 0;
        int leftCount = diameterOfBinaryTree1(root.left);
        int rightCount =  diameterOfBinaryTree1(root.right);
        if (leftCount + rightCount > maxValue)
            maxValue = leftCount + rightCount;

        return Math.max(leftCount, rightCount) + 1;
    }



}
