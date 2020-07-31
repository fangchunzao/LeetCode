package com.leetcode.iv.dic;

import java.util.ArrayList;
import java.util.List;

/**
 * description 面试题 08.09. 括号
 *
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-27 20:59:46
 */
public class Dic08_09 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", list);
        return list;
    }

    public void generateParenthesis(int n, int left, int right, String str, List<String> list) {
        if (n == left && n == right) {
            list.add(str);
            return;
        }
        if (left < n) {
            generateParenthesis(n, left + 1, right, str + "(", list);
        }

        if (right < left) {
            generateParenthesis(n, left, right + 1, str + ")", list);
        }

    }


}
