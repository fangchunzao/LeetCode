package com.leetcode.stock.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/11/13 10:34
 **/
public class LeetCode3 {

    public static void main(String[] args) {
        LeetCode3 obj = new LeetCode3();
        System.out.println(obj.lengthOfLongestSubstring("dvdf"));
    }

    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        // 不重复数组窗口
        List<Character> existList = new ArrayList<>();
        int max = 0;
        for(char ch : s.toCharArray()) {
            // 窗口滑动 将数组前面的重复元素依次删除
            while (existList.contains(ch)) {
                existList.remove(0);
            }
            existList.add(ch);
            max = Math.max(max, existList.size());
        }
        return Math.max(max, existList.size());
    }


    // 作者：LeetCode
    // 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int lengthOfLongestSubstring1 (String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0,    // 最大值
                i = 0,  // 字符串前指针
                j = 0;  // 字符串后指针
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


}
