package com.leetcode.iv.dic;

import com.leetcode.struct.ListNode;

/**
 * description 面试题 02.04. 分割链表
 *
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)
 * 分割元素 x 只需处于“右半部分”即可
 * 其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-01 21:17:13
 */
public class Dic02_04 {

    /**
     * 使用双指针
     * 左侧指针指向大于x的位置  右侧指针指向小于x的位置 互换
     * 原地置换
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode left = head;
        while (left != null) {
            while (left != null && left.val < x) {
                left = left.next;
            }
            // 第二个指针从第一个指针的位置开始 找到小于x的节点
            ListNode right = left;
            while (right != null && right.val >= x) {
                right = right.next;
            }
            if (left != null && right != null) {
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
            } else {
                break;
            }
        }
        return head;
    }

    /**
     * 还可以根据目标值分割成俩链表最后合并就可以了
     * 需要使用多余的空间
     */


}
