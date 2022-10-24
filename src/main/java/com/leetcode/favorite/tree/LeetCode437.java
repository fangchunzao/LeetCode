package com.leetcode.favorite.tree;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode437 {


    // 1,-2,-3
    //-2
    // res=2
    // -2,null,-3
    // -3
    // res=1
    // 0,1,1
    // 1
    // res=4
    public static void main(String[] args) {
        LeetCode437 obj = new LeetCode437();
        TreeNode treeNode = TreeNode.newListNode(new Integer[]{ 1,-2,-3});

        System.out.println(obj.hasPathSum(treeNode, -2));
    }

    public int hasPathSum(TreeNode root, int targetSum) {
        hasPathSum(root, targetSum, 0, new ArrayList<>());
        return resCount;
    }

    int resCount = 0;
    public void hasPathSum(TreeNode root, int targetSum, int curr, List<Integer> list) {
        if (root == null) {
            return;
        }
        curr += root.val;
        list.add(root.val);
        check(curr, targetSum, list);
        hasPathSum(root.left, targetSum, curr, list);
        hasPathSum(root.right, targetSum, curr, list);
        list.remove(list.size() - 1);
    }

    public void check(int num, int target, List<Integer> list) {
        if (num == target) {
            resCount++;
        }
        if (list.size() < 2) {
            return;
        }
        // 大于target 滑动窗口缩小
        List<Integer> tempList = new ArrayList<>(list);
        for (int i = 0; i < tempList.size() ; i++) {
            if (i == tempList.size() - 1) {
                return;
            }
            num = num - tempList.get(i);
            if (num == target) {
                resCount++;
            }
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        if(root.val == sum) {
            count++;
        }
        count += dfs(root.left, sum -root.val) +  dfs(root.right, sum - root.val);

        return count;

    }

}
