package com.leetcode.train.queue_stack.bfs_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * @author FCZ
 * @since 2018/10/22 11:10
 */
public class BFS3 {

    public static void main(String[] args) {
        System.out.println(numSquares(999));
    }

    public static int numSquares(int n) {
        if(isSquare(n))  return 1;  // 如果n就是完全平方数 直接返回

        Queue<Integer> queue = new LinkedList<>(); // 待处理队列
        queue.offer(n);
        int count = 0; // 深度

        while (!queue.isEmpty()) {
            //  按层数遍历
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int top = queue.poll();
                for (int j = 1; j <= Math.sqrt(top); j++) {
                    // 当计算后 为完全平方数 直接返回
                    int m = top - j*j;
                    if (isSquare(m)) {
                        count += 2;
                        return count;
                    }
                    queue.offer(m);
                }
            }
            count++;
        }
        return count;
    }

    /**
     * 判断是否为完全平方数
     * @param n
     * @return
     */
    public static boolean isSquare(int n){
        double temp = Math.sqrt(n);
        int m = (int) temp;
        return m*m==n;
    }
}
