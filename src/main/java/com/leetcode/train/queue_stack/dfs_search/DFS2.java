package com.leetcode.train.queue_stack.dfs_search;

import java.util.*;

/**
 * @author FCZ
 * @since 2018/10/29 16:00
 */
public class DFS2 {

    public static void main(String[] args) {
        UndirectedGraphNode n0=new UndirectedGraphNode(0);
        UndirectedGraphNode n1=new UndirectedGraphNode(1);
        UndirectedGraphNode n2=new UndirectedGraphNode(2);

        n0.neighbors.add(n1);
        n0.neighbors.add(n2);
//        n1.neighbors.add(n0);
        n1.neighbors.add(n2);
        n2.neighbors.add(n2);

        UndirectedGraphNode result = cloneGraph(n0);
        int i =1;
    }


    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();  // 存放访问过的节点
        return dfs(map, node);
    }

    private static UndirectedGraphNode dfs(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if (map.containsKey(node)) {  // 存在key
            return map.get(node);
        }
        // 复制主节点
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node, cloneNode);
        // 复制 子节点
        for(UndirectedGraphNode nodes : node.neighbors) {
            cloneNode.neighbors.add(dfs(map, nodes));
        }
        return cloneNode;
    }

    private static UndirectedGraphNode dfs1(Map<Integer, UndirectedGraphNode> map, UndirectedGraphNode node) {
        // 是否存在 存在返回
        UndirectedGraphNode cloned = map.get(node.label);
        if (cloned != null) return cloned;
        // clone一个
        cloned = new UndirectedGraphNode(node.label);
        map.put(cloned.label, cloned);
        // 加入子节点
        for(UndirectedGraphNode neighbor: node.neighbors) {
            cloned.neighbors.add(dfs1(map,neighbor));
        }
        return cloned;
    }

}


class UndirectedGraphNode{
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};