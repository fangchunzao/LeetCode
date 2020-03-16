package com.leetcode.iv.offer;

import java.util.Stack;

/**
 * 面试题33. 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer33 {

    // 递归分治
    // 对于 [ 左子树 | 右子树 | 根节点 ] 中的左（右）子树，仍满足后序遍历和二叉搜索树性质
    // 右子树 > 根节点 > 左子树
    // 从根节点进行递归 找到左子树和右子树 判断是否满足条件
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int low, int high) {
        if (low >= high) return true;
        // 找到左右子树的分割点
        int index = low;
        // 从左往右 比根节点小的都是左子树
        while (postorder[index] < postorder[high])
            index++;
        // 找到分割点了
        int split = index;
        // 分割点右边的都大于 根节点
        while (postorder[index] > postorder[high])
            index++;
        // 如果没有走到最后 说明中间存在小节点 不满足条件
        if (index != high) return false;
        // 递归判断左右子树是否满足条件
        return verifyPostorder(postorder, low, split - 1) &&
                verifyPostorder(postorder, split, high - 1);
    }

    // 辅助单调栈
    // 后序遍历倒序： [ 根节点 | 右子树 | 左子树 ] 。类似 先序遍历的镜像
    // 即先序遍历为“根、左、右”的顺序，而后序遍历的倒序为“根、右、左”顺序
    //
    //  1. 初始化： 单调栈 stack ，父节点值 root （初始值为正无穷大，以保证第一轮判断正确）
    //  2. 倒序遍历 postorder 记每个节点为 i
    //      1. 判断： 若 i > root ，说明此后序遍历序列不满足二叉搜索树性质，直接返回 false
    //      2. 循环出栈：当栈不为空 且i < stack.peek() 时循环执行出栈，并将出栈节点赋值给 root
    //      3. 入栈： 将当前节点 i 入栈
    //  3. 若遍历完成 说明满足条件
    //​
    //  作者：jyd
    //  链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
    //  来源：力扣（LeetCode）
    //  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean verifyPostorder1(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }


}
