package com.leetcode.iv.dic;

/**
 * description 面试题 01.09. 字符串轮转
 *
 * 字符串轮转。给定两个字符串s1和s2
 * 请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-06-30 20:53:46
 */
public class Dic01_09 {

    // s2首尾拼接 就能还原出s1
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String ss = s2 + s2;
        return ss.contains(s1);
    }

    // 如果一个字符串是另一个字符串的旋转
    // 那么它就是在某个特定点上的旋转。
    // 例如，字符串waterbottle在3处的旋转意味着在第三个字符处切割waterbottle，
    // 并在左半部分（wat）之前放置右半部分（erbottle）
    public boolean isFlipedString1(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        for (int i = 1; i < s1.length(); i++) {
            if (s2.equals(s1.substring(i) + s1.substring(0, i))) {
                return true;
            }
        }

        return false;
    }

}
