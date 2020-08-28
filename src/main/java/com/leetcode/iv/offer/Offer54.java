package com.leetcode.iv.offer;

import com.leetcode.struct.TreeNode;

/**
 * description 面试题54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since  2020-06-04 09:45
 *
 * @since 2020-08-18 复习
 **/
public class Offer54 {

    /**
     * 二叉搜索树寻找第K大的节点
     * 可以通过右 -> 中 -> 左的方式找到最大值
     */
    int res = 0, count = 0;
    public int kthLargest(TreeNode root, int k) {
        kthLargest1(root, k);
        return res;
    }

    public void kthLargest1(TreeNode root, int k) {
        if (root == null)
            return;

        kthLargest(root.right, k);
        if (++count == k) {
            res = root.val;
            return;
        }
        kthLargest(root.left, k);
    }

}
