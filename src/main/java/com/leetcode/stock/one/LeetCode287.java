package com.leetcode.stock.one;

/**
 * 287. 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/11/6 15:56
 **/
public class LeetCode287 {

    public static void main(String[] args) {
        LeetCode287 obj = new LeetCode287();
        System.out.println(obj.findDuplicate(new int[] {2,5,9,6,9,3,8,9,7,1}));
    }

    // 可以使用 集合 或者 排序 但是不满足条件
    // 二分法
    // 作者：liweiwei1419
    // 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int findDuplicate1(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            int counter = 0;
            for (int num : nums) {
                if (num <= mid) {
                    counter += 1;
                }
            }
            if (counter > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    //弗洛伊德的乌龟和兔子（循环检测） 存在一个环  快慢指针
    public int findDuplicate(int[] nums) {
        // [2,5,9,6,9,3,8,9,7,1]
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }



}
