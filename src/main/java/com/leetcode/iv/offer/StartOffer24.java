package com.leetcode.iv.offer;

import com.leetcode.struct.ListNode;

/**
 * 面试题24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-25 复习
 *
 */
public class StartOffer24 {

    // 递归法
    // 使用递归函数，一直递归到链表的最后一个结点，该结点就是反转后的头结点，记作 retret .
    // 此后，每次函数在返回的过程中，让当前结点的下一个结点的 nextnext 指针指向当前节点。
    // 同时让当前结点的 nextnext 指针指向 NULLNULL ，从而实现从链表尾部开始的局部反转
    // 当递归函数全部出栈后，链表反转完成。
    //
    // 作者：huwt
    // 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-yi-dong-de-shuang-zhi-zhen-jia/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    // 双指针
    // 定义两个指针： prepre 和 curcur ；prepre 在前 curcur 在后。
    // 每次让 prepre 的 nextnext 指向 curcur ，实现一次局部反转
    // 局部反转完成之后， prepre 和 curcur 同时往前移动一个位置
    // 循环上述过程，直至 prepre 到达链表尾部
    //
    // 作者：huwt
    // 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-yi-dong-de-shuang-zhi-zhen-jia/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = null, first = head;
        while (first != null) {
            ListNode ln = first.next;

            first.next = second;
            second = first;
            first = ln;
        }
        return second;
    }

    // 妖魔化的双指针
    // 原链表的头结点就是反转之后链表的尾结点，使用 headhead 标记 .
    // 定义指针 curcur，初始化为 headhead .
    // 每次都让 headhead 下一个结点的 nextnext 指向 curcur ，实现一次局部反转
    // 局部反转完成之后，curcur 和 headhead 的 nextnext 指针同时 往前移动一个位置
    // 循环上述过程，直至 curcur 到达链表的最后一个结点 .
    //
    // 作者：huwt
    // 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-yi-dong-de-shuang-zhi-zhen-jia/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        //  1 -> 2 -> 3 -> 4
        while (head.next != null) {
            // node = 3 -> 4
            ListNode node = head.next.next;
            // head  1 -> 2 -> 1 -> 2 -> 1 -> 2
            // cur             1 -> 2 -> 1 -> 2
            head.next.next = cur;
            // head  1 -> 2 -> 2 -> 1 -> 2 -> 1 -> 2 -> 1
            // cur             2 -> 1 -> 2 -> 1 -> 2 -> 1
            cur = head.next;
            // head      1 -> 3 -> 4
            // cur  2 -> 1 -> 3 -> 4
            head.next = node;
        }
        return cur;
    }






}
