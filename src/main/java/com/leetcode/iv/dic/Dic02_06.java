package com.leetcode.iv.dic;

import com.leetcode.struct.ListNode;

/**
 * description 面试题 02.06. 回文链表
 *
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-02 20:30:57
 */
public class Dic02_06 {

    /**
     * 1，采用快慢两个指针去寻找链表的中间节点；
     * 2，根据链表的中间节点反转后一半的链表；
     * 3，迭代比较链表前一半的元素和后一半的元素，判断节点的值是否相等，得出是否为回文。
     *
     * 1 2 3 4 5 4 3 2 1
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fastNode = head, lowNode = head;
        // 快慢指针 遍历完后 慢指针指的就是中间节点
        while (fastNode != null && fastNode.next != null) {
            lowNode = lowNode.next;
            fastNode = fastNode.next.next;
        }
        // 反转后半部分的链表
        lowNode = reverseLinked(lowNode);
        // 前后链表对比
        while (lowNode != null) {
            if (lowNode.val != head.val) {
                return false;
            }
            lowNode = lowNode.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseLinked(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }


    // 将链表转成数组 直接判断回文 实现简单不写了
    public boolean isPalindrome1(ListNode head) {
        return false;
    }




}
