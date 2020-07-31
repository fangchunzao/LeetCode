package com.leetcode.iv.dic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * description 面试题 08.08. 有重复字符串的排列组合
 *
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
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
 * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-27 20:52:17
 */
public class Dic08_08 {

    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        permutation(S.toCharArray(), 0, list);
        return list.toArray(new String[]{});
    }

    public void permutation(char[] chars, int index, List<String> list) {
        if (index == chars.length) {
            list.add(new String(chars));
        }
        // 记录字符是否已经出现过
        // boolean[] visited = new boolean[58];
        Set<Character> visited = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            /*if (visited[chars[i] - 'A'])
                continue;
            visited[chars[i] - 'A'] = true;*/
            if (visited.contains(chars[i]))
                continue;
            visited.add(chars[i]);
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
