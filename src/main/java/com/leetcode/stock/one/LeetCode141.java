package com.leetcode.stock.one;

import java.util.*;

/**
 * 141. 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/26 10:06
 **/
public class LeetCode141 {

    public static void main(String[] args) {
        LeetCode141 obj = new LeetCode141();

        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode2;
        System.out.println(obj.hasCycle(listNode));
    }

    // 哈希表解法
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // 双指针解法
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode lowNode = head;
        ListNode fastNode = head.next;
        // 如果存在环 fastNode一定会追上lowNode 转一圈绕回来了， 如果不存在环就会到达链表尾部
        while (lowNode != fastNode) {
            // fastNode到达链表尾部
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            lowNode = lowNode.next;
            fastNode = fastNode.next.next;
        }
        //  fastNode追上lowNode
        return true;

    }


}
