package com.leetcode.iv.dic;

import com.leetcode.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * description 面试题 02.08. 环路检测
 *
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 *
 *   3 -> 2 -> 0 -> -4
 *        |          |
 *         ￣￣￣￣￣
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-02 21:35:07
 */
public class Dic02_08 {
    // 1 2 3 4 5 6 7 8

    // 假设 快慢指针slow和fast  在环内的任意节点开始到再次相遇的路径为 Y， 从链表头到环开始节点的路径为 X
    // 那么 第一次循环的遍历路径为 X + Y
    // 第二次从链表头 遍历到X 就是环点了


    // 检测有没有环，使用快慢指针slow和fast
    // 找位置，当找到环之后，slow从head出发，fast从相遇点出发，一次都走一步，再次相遇为环的入口点

    //
    // 证明为何第二步的方法能够找到入口点：
    // 令： m 表示从head到入口的距离， d 表示入口到相遇点的距离, r 表示环的长度，ls表示slow走的长度，lf表示fast走的长度
    // 有： ls = m + d, lf = m + d + n * r (n为正整数 循环次数)， lf = 2 * ls
    // 则： m + d + n * r = 2 * (m + d)
    // 则： m = n * r - d， n >= 1
    // 则： m = r - d + (n - 1)r， n >= 1

    // 当n=1时，m = r - d, 即”head到入口的距离（m）“等于”相遇点到入口的距离(r - d)“， 使用第二步方法能找到入口点；
    // 当n=2时，m = 2 * r - d, 等价于： m = (r - d) + r, 即”head到入口的距离（m）“等于”相遇点到入口的距离（r - d）加环长度“，
    //   使用第二步方法会让fast指针多走一个环的长度，然后slow和fast还会相遇在环入口
    // 当n>2时，同理

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 此处如果用if (slow != null && fast != null && slow.val == fast.val) 会超出时间限制
            if (slow == fast) {
                break;
            }
        }
        // 没有环
        if (fast == null || fast.next == null) {
            return null;
        }
        // slow从head开始，fast从相遇点开始，一步一步走再次相遇即为环入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    // 保存每一个next节点 重复就是环开始节点
    // 使用了O(N)的空间
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> exist = new HashSet<>();
        while (head != null) {
            if (exist.add(head))
                head = head.next;
            else
                return head;
        }
        return null;
    }


}
