package com.leetcode.iv.dic;

import com.leetcode.struct.ListNode;

/**
 * description 面试题 02.05. 链表求和
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 *
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-01 21:39:10
 */
public class Dic02_05 {

    /**
     * 不能将L1 或 L2 转成数字 数字可能过大
     * 按照加法规则 依次递加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode resNode = head;
        int stepNum = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + stepNum;
            if (sum > 10) {
                stepNum = sum / 10;
                sum %= 10;
            } else {
                stepNum = 0;
            }
            head.next = new ListNode(sum);
            head = head.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (stepNum != 0) {
            head.next = new ListNode(stepNum);;
        }
        return resNode.next;
    }

    /**
     * 进阶：假设这些数位是正向存放的，请再做一遍。
     *
     * 示例：
     *
     * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     * 输出：9 -> 1 -> 2，即912
     *
     * 递归计算
     */
    ListNode listNode = new ListNode(-1);
    ListNode resNode = listNode;
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int stepNum = addTwoNumbers3(l1.next, l2.next);
        if (stepNum != 0) {
            listNode.next = new ListNode(stepNum);;
        }
        return resNode.next;
    }
    public int addTwoNumbers3(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return 0;

        int stepNum = addTwoNumbers3(l1 == null ? null : l1.next,
                l2 == null ? null : l2.next);

        int num1 = l1 == null ? 0 : l1.val;
        int num2 = l2 == null ? 0 : l2.val;
        int sum = num1 + num2 + stepNum;
        if (sum >= 10) {
            sum %= 10;
            stepNum = sum / 10;
        } else {
            stepNum = 0;
        }
        listNode.next = new ListNode(sum);
        listNode = listNode.next;
        return stepNum;

    }

}
