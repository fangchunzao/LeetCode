package com.leetcode.iv.offer;

import com.leetcode.struct.TreeNode;

/**
 * description 面试题26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-06-16 16:32
 **/
public class Offer26 {

    /**
     * 递归判断
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
       if (A == null || B == null)
            return false;
       return isSubChild(A, B)  // 判断当前第一个节点
               || isSubStructure(A.left, B)  // 判断左子树
               || isSubStructure(A.right, B); // 判断右子树
    }

    /**
     * 判断B是否A的子树
     */
    public boolean isSubChild(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return isSubChild(A.left, B.left) && isSubChild(A.right, B.right);
    }


}
