package com.leetcode.stock.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
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
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @description
 * @date 2019-12-10 17:11
 **/
public class LeetCode22 {

    public static void main(String[] args) {
        LeetCode22 obj = new LeetCode22();
        obj.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis1(result, "", 0, 0, n);
        return result;
    }

    public void generateParenthesis1(List<String> result, String str, int left, int right, int n) {
        if (left == n && right == n) {
            // add
            result.add(str);
            return;
        }
        if (left < n) {
            generateParenthesis1(result, str + "(" , left + 1, right, n);
        }
        if (left > right) {
            generateParenthesis1(result, str + ")" , left, right + 1, n);
        }
    }

}
