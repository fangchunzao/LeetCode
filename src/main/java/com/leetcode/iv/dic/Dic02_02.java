package com.leetcode.iv.dic;

import com.leetcode.struct.ListNode;

/**
 * description 面试题 02.02. 返回倒数第 k 个节点
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-01 20:58:54
 */
public class Dic02_02 {

    public int kthToLast(ListNode head, int k) {
        ListNode first = head;
        while (k-- > 0) {
            first = first.next;
        }
        while (first != null) {
            head = head.next;
            first = first.next;
        }
        return head.val;
    }

}
