package com.leetcode.stock.one;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/11/8 10:21
 **/
public class LeetCode2 {

    public static void main(String[] args) {
        LeetCode2 obj = new LeetCode2();

        ListNode listNode1 = new ListNode(5);
//        ListNode listNode2 = new ListNode(4);
//        ListNode listNode3 = new ListNode(3);

//        listNode1.next = listNode2;
//        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(4);

//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        obj.addTwoNumbers(listNode1, listNode4);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        boolean flag = false;
        ListNode listNode = new ListNode(-1);
        ListNode resultNode = null;
        while (l1 != null || l2 != null || flag) {
            int num1 = 0, num2 = 0;
            // 依次获取链表值
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            // 两值相加
            int sum = num1 + num2;
            // 前一位大于10 进1
            if(flag) {
                sum++;
                flag = false;
            }
            // 两数相加大于10
            if (sum >= 10) {
                sum %= 10;
                flag = true;
            }
            // 放入listNode中
            if (listNode.val == -1) {
                // 第一个节点的初始化
                listNode = new ListNode(sum);
                resultNode = listNode;
            } else {
                listNode.next = new ListNode(sum);
                listNode = listNode.next;
            }
        }
        return resultNode;
    }

}
