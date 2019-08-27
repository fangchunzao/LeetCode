package com.leetcode.stock.one;

/**
 * 242. 有效的字母异位词 EASY
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/27 09:54
 **/
public class LeetCode242 {

    /**
     * 字母异位词  也就是俩单词的每个字母位置不一样就行了
     *
     * 还有一种解法 是排序，两个字符串排序后 就是一样的字符串了 直接比较就行
     *
     */
    public static void main(String[] args) {
        LeetCode242 obj = new LeetCode242();

        System.out.println(obj.isAnagram("a", "b"));
    }

    /**
     * description S1 哈希表1
     * @author Mr.F
     * @since 2019/8/27
     **/
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        for (int count : hash) {
            if (count != 0)
                return false;
        }
        return true;
    }
    /**
     * description  S2 哈希表2
     * @author Mr.F
     * @since 2019/8/27
     **/
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
