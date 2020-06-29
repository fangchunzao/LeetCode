package com.leetcode.iv.dic;

import java.util.HashSet;
import java.util.Set;

/**
 * description 面试题 01.01. 判定字符是否唯一
 *
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-06-29 20:25:39
 */
public class Dic01_01 {

    /**
     * 哈希表
     * 空间复杂度 O(n) 时间复杂度O(n)
     */
    public boolean isUnique(String astr) {
        Set<Character> hash = new HashSet<>();
        for(char ch : astr.toCharArray()) {
            if (hash.contains(ch))
                return false;
            hash.add(ch);
        }
        return true;
    }


}
