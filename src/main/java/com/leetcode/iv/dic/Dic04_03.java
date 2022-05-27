package com.leetcode.iv.dic;

import com.leetcode.struct.TreeNode;

import java.util.*;

/**
 * description 面试题 04.03. 特定深度节点链表
 *
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-13 20:38:28
 */
public class Dic04_03 {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null)
            return null;
        List<ListNode> resListNode = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nums[i] = node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            ListNode preNode = null;
            for (int i = 0; i < nums.length; i++) {
                ListNode node = new ListNode(nums[i]);
                if (preNode != null) {
                    resListNode.add(node);
                } else {
                    preNode.next = node;
                }
                preNode = node;
            }
        }
        ListNode[] res = new ListNode[resListNode.size()];
        for (int i = 0; i < resListNode.size(); i++) {
            res[i] = resListNode.get(i);
        }
        return res;
//        return resListNode.toArray(new ListNode[]{});
//        return resListNode.toArray(new ListNode[0]);

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
