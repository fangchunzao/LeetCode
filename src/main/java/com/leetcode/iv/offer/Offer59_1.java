package com.leetcode.iv.offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * description 面试题59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 *  [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-06-10 15:32
 **/
public class Offer59_1 {

    public static void main(String[] args) {
        Offer59_1 obj = new Offer59_1();
        System.out.println(Arrays.toString(obj.maxSlidingWindow(new int[]
                {1,3,-1,-3,5,3,6,7}, 3
        )));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0)
            return new int[0];
        int[] res = new int[nums.length - k  + 1];
        // 维护一个单调递减的队列
        Deque<Integer> deque = new LinkedList<>();

        for (int windowLeft = 1 - k, windowRight = 0; windowRight < nums.length; windowLeft++, windowRight++) {
            // 维护窗口前面的推进
            if (windowLeft > 0 && deque.peekFirst() == nums[windowLeft - 1]) {
                deque.removeFirst();
            }
            // 维护窗口内的单调递减 以及末尾的后推
            while (!deque.isEmpty() && deque.peekLast() < nums[windowRight]) {
                deque.removeLast();
            }
            deque.addLast(nums[windowRight]);
            if(windowLeft >= 0)
                res[windowLeft] = deque.peekFirst();
        }
        return res;
    }

    /**
     * 单调队列
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            // 窗口向前推进 删除前面的元素
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            // 如果碰见大于队列尾部的数 删除 保证递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            if(i >= 0)
                res[i] = deque.peekFirst();  // 记录窗口最大值
        }
        return res;
    }


    /**
     * 模拟法 最慢了
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        int[] res = new int[nums.length - k + 1];
        int windowLeft = 0, windowRight = k - 1;
        while (windowRight < nums.length) {
            res[windowLeft] = maxValue(nums, windowLeft, windowRight);
            windowLeft++;
            windowRight++;
        }
        return res;
    }

    public int maxValue(int[] nums, int left, int right) {
        int maxCount = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            maxCount = Math.max(maxCount, nums[i]);
        }
        return maxCount;
    }

}
