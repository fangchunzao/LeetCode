package com.leetcode.iv.dic;

/**
 * description 面试题 01.05. 一次编辑
 *
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-06-29 21:17:17
 */
public class Dic01_05 {

    /**
     * 主要思路是，只有一个地方需要修改，那么不妨定位到不同字符处。有以下两种情况
     * （1）leetcode 与 leetkode。
     * 那么我们需要找到 'c' 和 'k'，然后比较 'ode' 和 'ode' 是否相同。
     * （2）leetcode 与 leetode。
     * 我们发现 'c' 和 'o' 不相同，然后比较 'ode' 和 'ode' 是否相同。
     */
    public static boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if (len2 > len1) return oneEditAway(second, first);

        // 保持第一个比第二个长
        for (int i = 0; i < len2; i++){
            if (first.charAt(i) != second.charAt(i)){
                // 如果是长度相同字符串，那就比较下一个，如果长度不一样，那就从该字符开始进行比较。
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1 : i));
            }
        }
        return true;
    }

















    public static boolean oneEditAway1(String first, String second) {
        if (first == null || second == null) return false;
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        // 保证first是最长的
        if (len1 < len2)
            return oneEditAway1(second, first);

        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1 : i));
            }
        }
        return true;
    }


}
