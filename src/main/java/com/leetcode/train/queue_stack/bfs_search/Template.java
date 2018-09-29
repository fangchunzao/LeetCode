package com.leetcode.train.queue_stack.bfs_search;


import java.util.*;

/**
 * @author FCZ
 * @since 2018/9/29 09:58
 */
public class Template {

    class Node {

        private List<Node> nerighbors() {
            return new ArrayList<Node>(){{add(new Node());}};
        };
    }

    /**
     * Return the length of the shortest path between root and target node.
     */
    int BFS1(Node root, Node target) {
        Queue<Node> queue = new PriorityQueue<>();  // store all nodes which are waiting to be processed
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        // add root to queue;
        queue.add(root);
        // BFS
        while (!queue.isEmpty()) {
            // 逐层进行对比
            step = step + 1;
            // iterate the nodes which are already in the queue
            // 当前层有多少节点
            int size = queue.size();
            // 找出这些节点是否存在target，并且把下一层的节点放入队列
            for (int i = 0; i < size; ++i) {
                // Node cur = the first node in queue;
                Node cur = queue.poll();
                // return step if cur is target;
                if (target.equals(cur)) {
                    return step;
                }

                // 将与当前节点相连的下一层节点放入队列
                // for (Node next : the neighbors of cur) {
                for (Node next : cur.nerighbors()) {
                    // add next to queue;
                    queue.add(next);
                }
                // remove the first node from queue;
            }
        }
        return -1;          // there is no path from root to target
    }

    /**
     * Return the length of the shortest path between root and target node.
     * 防止相同节点被加入queue
     */
    int BFS2(Node root, Node target) {
        Queue<Node> queue = new PriorityQueue<>();  // store all nodes which are waiting to be processed
        Set<Node> used = new HashSet<>();     // store all the used nodes
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        // add root to queue;
        // add root to used;
        queue.add(root);
        used.add(root);
        // BFS
        while (!queue.isEmpty()) {
            step = step + 1;
            // iterate the nodes which are already in the queue
            // 遍历当前层节点
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                if (target.equals(cur)) return step;

                for (Node next : cur.nerighbors()) {
                    if (!next.equals(used)) {
                        queue.add(next);
                        used.add(next);
                    }
                }
            }
        }
        return -1;          // there is no path from root to target
    }

}
