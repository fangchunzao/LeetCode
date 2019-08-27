package com.leetcode.stock.one;

/**
 * 387 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class LeetCode387 {


    /**
     * description S1 哈希表
     * @author Mr.F
     * @since 2019/8/27
     **/
    public int firstUniqChar(String s) {
        int[] hashTable = new int[26];

        for (int i = 0; i < s.length(); i++)
            hashTable[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (hashTable[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

}
