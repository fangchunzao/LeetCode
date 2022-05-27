package com.leetcode.iv.must;

import java.util.HashMap;
import java.util.Map;

/**
 * 96. 不同的二叉搜索树
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *输入：n = 3
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 *
 */
public class Must96 {

    public static void main(String[] args) {
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        //如果只有0，或者1个节点，则可能的子树情况为1种
        if (n == 0 || n == 1){
            return 1;
        }

        if (map.containsKey(n)){
            return map.get(n);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            //当用i这个节点当做根节点时

            //左边有多少种子树
            int leftNum = numTrees(i-1);

            //右边有多少种子树
            int rightNum = numTrees(n-i);

            //乘起来就是当前节点的子树个数
            count+=leftNum*rightNum;
        }

        map.put(n,count);

        return count;
    }

    // n=1  res=1
    // n=2  res=2
    // n=3  res=5
    // n=4  res=14
    // n=5  res=42

    // i = 4
    // G[0] * G[3]  1*5
    // G[1] * G[2]  1*2
    // G[2] * G[1]  2*1
    // G[3] * G[0]  5*1
    public int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    /**
     * 数学法
     * 卡塔兰数 呜呜呜
     */
    public int numTrees2(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
