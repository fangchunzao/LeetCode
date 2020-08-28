package com.leetcode.iv.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题48. 最长不含重复字符的子字符串
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * s.length <= 40000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-25 复习
 *
 */
public class StartOffer48 {

    // 动态规划 + 哈希表 abbbac
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            // dp[j - 1] -> dp[j]
            // temp 记录当前不重复元素的最大长度
            // (j - i) 表示从当前元素到上一个该元素的长度
            // tem > (j - i) 说明temp中存在了重复的元素
            if (tmp < j - i) {
                // tmp没有重复元素
                tmp++;
            } else {
                // tmp 存在相同元素 重置为 j-i (当前的最大值)
                tmp =  j - i;
            }
//            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    // 双指针  + 哈希表
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        // 记录每一个元素对应的位置
        Map<Character, Integer> map = new HashMap<>();
        char[] strCh = s.toCharArray();
        int start = 0, // 左侧的起点
         maxCount = 0;
        for (int i = 0; i < strCh.length; i++) {
            if (map.containsKey(strCh[i])) {
                // 更新起点 与存在的元素位置进行判断，更新start
                start = Math.max(start, map.get(strCh[i]) + 1);
            }
            map.put(strCh[i], i);
            maxCount = Math.max(maxCount, i - start + 1);
        }
        return maxCount;
    }

    // 双指针 + 哈希表
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int start = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j))) {
                start = Math.max(start, dic.get(s.charAt(j))); // 更新左指针 i
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - start); // 更新结果
        }
        return res;
    }
    // 最简单的滑动窗口
    public int lengthOfLongestSubstring5(String s) {
        if (s == null || s.length() == 0) return 0;

        List<Character> list = new ArrayList<>();
        int maxCount = 0;
        for(char ch : s.toCharArray()) {
            if (list.contains(ch)) {
                // 存在相同的字符 从前往后 移除元素
                while (list.contains(ch)) {
                    list.remove(0);
                }
            }
            list.add(ch);
            maxCount = Math.max(maxCount, list.size());
        }
        return maxCount;
    }




}
