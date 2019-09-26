package com.leetcode.stock.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。 
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/26 09:31
 **/
public class LeetCode138 {

    public static void main(String[] args) {

    }

    // 回溯算法 使用hash保存已经遍历过的节点
    Map<Node, Node> hash = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (hash.containsKey(head)) return hash.get(head);

        Node copy = new Node();
        copy.val = head.val;
        hash.put(head, copy);

        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        return copy;
    }

}
