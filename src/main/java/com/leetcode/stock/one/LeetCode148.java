package com.leetcode.stock.one;

/**
 *
 * 148. 排序链表
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/29 10:00
 **/
public class LeetCode148 {

    public static void main(String[] args) {

    }

    // 归并排序 快慢指针找链表中点 辅助链表有序合并链表
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 找到中点 slow 后，执行 slow.next = None 将链表切断。
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归节点 拆分
        ListNode left = sortList(head); // 前半段
        ListNode right = sortList(tmp); // 后半段
        //  将两个排序链表合并，转化为一个排序链表 双指针法合并，建立辅助ListNode h 作为头部
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        // 上面的遍历 会提前结束 存在left OR right 的最大节点没有合并
        h.next = left != null ? left : right;
        // 第一个节点是初始化的0 所以要从下一个节点返回
        return res.next;
    }

    public ListNode sortList1(ListNode head) {
        return null;
    }

}
