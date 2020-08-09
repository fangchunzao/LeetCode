package com.leetcode.iv.offer;

import com.leetcode.struct.ListNode;

/**
 * 面试题18. 删除链表的节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-09 复习
 *
 */
public class Offer18 {

    public static void main(String[] args) {

    }

    // 双指针 往前走
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;

        ListNode newHead = head;
        ListNode newHead2 = head.next;
        while (newHead2 != null) {
            if (newHead2.val == val) {
                newHead.next = newHead2.next;
                break;
            }
            newHead = newHead.next;
            newHead2 = newHead2.next;
        }
        return head;
    }

    // 算法原题 使用O(1) 时间复杂度解题 参数为两个节点
    // 信息交换法

    //     作者：z1m
    //    链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/cong-on-dao-o1-by-ml-zimingmeng/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    ListNode deleteNode(ListNode head, ListNode val){
        if (head == null || val == null){
            return null;
        }
        if (val.next != null){
            // 待删除节点不是尾节点 直接 == next 就行
            ListNode next = val.next;
            val.val = next.val;
            val.next = next.next;
        } else if (head == val){
            // 待删除节点只有一个节点，此节点为头节点
            head = null;
        } else {
            // 待删除节点为尾节点 遍历到末尾删除尾节点
            ListNode cur = head;
            while (cur.next != val){
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }


}
