package com.leetcode.favorite.tree;

import com.leetcode.BaseMain;
import com.leetcode.struct.TreeNode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode124 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.newListNode(new Integer[]{-10,9,20,null,null,15,-7});
        new LeetCode124().maxPathSum(treeNode);
    }

    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSum1(root);
        return maxVal;
    }

    // maxVal 保存最大值结果
    // 返回值 返回当前节点路径最大和
    public int maxPathSum1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftVal = maxPathSum1(root.left);
        int rightVal = maxPathSum1(root.right);
        // 路径最大和
        int currMax = Math.max(Math.max(leftVal + root.val, rightVal + root.val), root.val);
        if (root.val > maxVal && maxVal < 0) {
            // 小于0 特殊处理
            maxVal = root.val;
        } else {
            // leftVal + rightVal + root.val(以自身为节点的最大路径)  最大路径和  自身值  maxVal 取最大值
            maxVal = Math.max(Math.max(Math.max(currMax, leftVal + rightVal + root.val), root.val), maxVal);
        }
        return currMax;
    }


}
