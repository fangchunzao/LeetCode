package com.leetcode.iv.must;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Must128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int n : nums) {
            numSet.add(n);
        }
        int maxLength = 0;
        for(int num : numSet) {
            // 这一步可以减少循环次数 直接找到连续字符里最小的 进行遍历
            if (!numSet.contains(num - 1)) {
                int currLength = 1;
                int currNum = num;
                while (numSet.contains(currNum+1)) {
                    currNum++;
                    currLength++;
                }
                maxLength = Math.max(currLength, maxLength);
            }
        }
        return maxLength;
    }

    //    作者：yimeixiaobai
    //    链接：https://leetcode.cn/problems/longest-consecutive-sequence/solution/xiao-bai-lang-ha-xi-ji-he-ha-xi-biao-don-j5a2/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int longestConsecutive2(int[] nums) {
        // key表示num，value表示num所在连续区间的长度
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            // 当map中不包含num，也就是num第一次出现
            if (!map.containsKey(num)) {
                // left为num-1所在连续区间的长度，更进一步理解为：左连续区间的长度
                int left = map.getOrDefault(num - 1, 0);
                // right为num+1所在连续区间的长度，更进一步理解为：右连续区间的长度
                int right = map.getOrDefault(num + 1, 0);
                // 当前连续区间的总长度
                int curLen = left + right + 1;
                ans = Math.max(ans, curLen);
                // 将num加入map中，表示已经遍历过该值。其对应的value可以为任意值。
                map.put(num, -1);
                // 更新当前连续区间左边界和右边界对应的区间长度
                map.put(num - left, curLen);
                map.put(num + right, curLen);
            }
        }
        return ans;
    }



}
