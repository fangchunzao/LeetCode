package com.leetcode.iv.dic;

import java.util.HashMap;
import java.util.Map;

/**
 * description 面试题 01.04. 回文排列
 *
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-06-29 21:04:53
 */
public class Dic01_04 {

    // 回文数的规律
    // 统计每个字符出现的次数 如果全是偶数次 肯定是了
    // 奇数次的字符只能有一个
    // 通过哈希表计算总数
    public static boolean canPermutePalindrome(String s) {

        Map<Character, Integer> hash = new HashMap<>();
        for(char ch : s.toCharArray()) {
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
        }

        int res = 0;
        for(Integer count : hash.values()) {
            res += count % 2;
        }
        return res < 2;
    }

    // 进化版
    public static boolean canPermutePalindrome1(String s) {

        char[] hashCount = new char[128];
        for (int i = 0; i < s.length(); i++) {
            hashCount[s.charAt(i)]++;
        }
        int res = 0;
        for (int i = 0; i < hashCount.length; i++) {
            res += hashCount[i] % 2;
        }
        return res < 2;
    }

}
