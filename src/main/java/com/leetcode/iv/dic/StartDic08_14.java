package com.leetcode.iv.dic;

import java.util.Arrays;

/**
 * description 面试题 08.14. 布尔运算
 *
 * 给定一个布尔表达式和一个期望的布尔结果 result，
 * 布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。
 * 实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 *
 * 示例 1:
 *
 * 输入: s = "1^0|0|1", result = 0
 *
 * 输出: 2
 * 解释: 两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * 示例 2:
 *
 * 输入: s = "0&0&0&1^1|0", result = 1
 *
 * 输出: 10
 * 提示：
 *
 * 运算符的数量不超过 19 个
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boolean-evaluation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-07-30 21:25:20
 */
public class StartDic08_14 {
    /**
     * 设dp[s][e][r]为从索引s到索引e值为r的方案数。那么，我们可以拿一个指针k(从s遍历到e - 1)
     * 将区间[s, e]分成两个部分，[s, k] 和 [k + 2, e]。
     * 其中k+1的位置是运算符。
     *
     * 同时，由于是布尔运算，因此左右两部分的结果页要么是0，要么是1。
     * 组合也就是四种情况，{00, 01, 10, 11}。
     * 然后判断这四种情况通过k+1位置的运算符算出来的值是不是能够等于r(dp[s][e][r]中的r)。
     * 能等的话，就将左右两部分的方案数相乘即可。
     *
     * 作者：yuruiyin
     * 链接：https://leetcode-cn.com/problems/boolean-evaluation-lcci/solution/java-ji-yi-hua-sou-suo-by-npe_tle/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     */
    private int[][][] dp;
    public int countEval(String s, int result) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        dp = new int[len][len][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return rec(arr, 0, len - 1, result);
    }

    /**
     * 返回从索引start到end值为result的不同括号方案的个数
     */
    private int rec(char[] arr, int start, int end, int result) {
        if (start == end) {
            return arr[start] - '0' == result ? 1 : 0;
        }

        if (dp[start][end][result] != -1) {
            return dp[start][end][result];
        }

        int ansCount = 0;
        for (int k = start; k < end; k += 2) {
            char operator = arr[k + 1];
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (getBoolAns(i, j, operator) == result) {
                        ansCount += rec(arr, start, k, i) * rec(arr,k + 2, end, j);
                    }
                }
            }
        }

        dp[start][end][result] = ansCount;
        return ansCount;
    }

    private int getBoolAns(int val1, int val2, char operator) {
        switch (operator) {
            case '&':
                return val1 & val2;
            case '|':
                return val1 | val2;
            case '^':
                return val1 ^ val2;
        }
        return val1 & val2;
    }


    // 布尔运算
    public int countEval1(String s, int result) {
        int n = s.length();
        int[][][] cache = new int[n][n][];
        char[] chars = s.toCharArray();
        int[] res = backtrack(chars, 0, chars.length - 1, cache);
        return result == 0 ? res[0] : res[1];
    }

    private int[] backtrack(char[] chars, int left, int right, int[][][] cache) {
        if (left >= right) {
            int[] arr = new int[2];
            arr[chars[left] - '0'] = 1;
            return arr;
        }
        if (cache[left][right] != null) {
            return cache[left][right];
        }
        int[] res = new int[2];
        for (int i = left; i <= right; i++) {
            if (chars[i] == '0' || chars[i] == '1') continue;
            int[] l = backtrack(chars, left, i - 1, cache);
            int[] r = backtrack(chars, i + 1, right, cache);
            switch (chars[i]) {
                case '&':
                    // 结果为0 三种情况：0 0，0 1，1 0
                    // 结果为1 一种情况：1 1
                    res[0] += (l[0] * r[0]) + (l[0] * r[1]) + (l[1] * r[0]);
                    res[1] += l[1] * r[1];
                    break;
                case '|':
                    // 结果为0 一种情况：0 0
                    // 结果为1 三种情况：1 1，0 1，1 0
                    res[0] += l[0] * r[0];
                    res[1] += (l[1] * r[1]) + (l[0] * r[1]) + (l[1] * r[0]);
                    break;
                case '^':
                    // 结果为0 二种情况：0 0，1 1
                    // 结果为1 两种情况：0 1，1 0
                    res[0] += (l[0] * r[0]) + (l[1] * r[1]);
                    res[1] += (l[0] * r[1]) + (l[1] * r[0]);
                    break;
                default:
                    break;
            }
        }
        return cache[left][right] = res;
    }



}
