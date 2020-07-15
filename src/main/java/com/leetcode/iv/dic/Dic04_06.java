package com.leetcode.iv.dic;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * description 面试题 04.06. 后继者
 *
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-14 14:15
 */
public class Dic04_06 {

    //        5
    //      / \
    //     3   6
    //    / \
    //   2   4
    //  /
    // 1
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // p存在右子树，直接后继就是右子树的最左节点
        if (p.right != null){
            p = p.right;
            while (p.left != null){
                p = p.left;
            }
            return p;
        }
        // p不存在右子树
        TreeNode node = root;
        // 保存后继节点
        TreeNode res = null;
        while (p != node){
            if (p.val < node.val){
                // node比p大，表示node在p的后继路径上
                res = node;// 左孩子的父节点
                node = node.left;
            }else {
                // node比p小，表示node在p的前驱路径上
                node = node.right;
            }
        }
        return res;
    }


    //按照中序遍历记录已访问过的节点
    List<TreeNode> lists =new ArrayList<>();

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        //左右两边访问的结果
        TreeNode leftRes = null, rightRes = null;
        if(root.left != null) {
            //左边搜索
            leftRes = inorderSuccessor2(root.left, p);
        }
        //左边搜到了，直接返回左边的结果
        if(leftRes != null)
            return leftRes;

        //加入lists时，判断上一个加入lists的是不是p节点
        if(lists.size() >= 1 && lists.get(lists.size() - 1) == p)
            //是的话代表当前这个节点就是结果节点，直接返回
            return root;

        //加入到list
        lists.add(root);

        if(root.right != null){
            //右边搜索
            rightRes = inorderSuccessor2(root.right,p);
        }
        //右边搜索到了的话返回右边搜索结果，否则返回默认null
        return rightRes;
    }


}
