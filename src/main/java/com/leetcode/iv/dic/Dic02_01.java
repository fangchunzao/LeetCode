package com.leetcode.iv.dic;

import com.leetcode.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * description 面试题 02.01. 移除重复节点
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-06-30 21:35:56
 */
public class Dic02_01 {

    // hash表保存存在的元素
    // 时间复杂度O(N) 空间复杂度O(N)
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> exist = new HashSet<>();
        exist.add(head.val);
        ListNode listNode = head;
        while (listNode.next != null) {
            if (exist.add(listNode.next.val)) {
                listNode = listNode.next;
            } else {
                listNode.next = listNode.next.next;
            }
        }
        listNode.next = null;
        return head;
    }

    // 不得使用临时缓冲区 暴力法
    // 时间复杂度O(N^2) 空间复杂度O(1)
    public ListNode removeDuplicateNodes1(ListNode head) {
        ListNode ob = head;
        while (ob != null) {
            ListNode oc = ob;
            while (oc.next != null) {
                if (oc.next.val == ob.val) {
                    oc.next = oc.next.next;
                } else {
                    oc = oc.next;
                }
            }
            ob = ob.next;
        }
        return head;
    }


}
