package com.leetcode.iv.offer;

import com.leetcode.struct.TreeNode;

import java.util.*;

/**
 * 面试题32 - II. 从上到下打印二叉树 II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer32_2 {

    // 辅助队列 按层遍历
    public List<List<Integer>> levelOrder1(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root != null) queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }


    // 递归实现
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        levelOrder(root, 1, levelMap);
        return  new ArrayList<>(levelMap.values());
    }

    public void levelOrder(TreeNode root, int level, Map<Integer, List<Integer>> levelMap) {
        if (root == null) return;

        // 存在该层
        List<Integer> list = new ArrayList<>();
        if (levelMap.containsKey(level)) {
            list = levelMap.get(level);
        }
        list.add(root.val);
        levelMap.put(level, list);
        levelOrder(root.left, level+1, levelMap);
        levelOrder(root.right, level+1, levelMap);
    }

}
