package com.leetcode.iv.dic;

import java.util.ArrayList;
import java.util.List;

/**
 * description 面试题 08.07. 无重复字符串的排列组合
 *
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-27 19:58:11
 */
public class Dic08_07 {

    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        permutation(S.toCharArray(), 0, list);
        return list.toArray(new String[]{});
    }


    public void permutation(char[] chars, int index, List<String> list) {
        if (index == chars.length) {
            list.add(new String(chars));
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permutation(chars, index + 1, list);
            swap(chars, index, i);
        }
    }

    public void swap(char[] chars, int i, int j) {
        if (i == j)
            return;
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
