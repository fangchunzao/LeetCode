package com.leetcode.stock.one;

/**
 * 10. 正则表达式匹配
 *
 *给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/11/20 10:48
 **/
public class LeetCode10 {

    public static void main(String[] args) {
        LeetCode10 obj = new LeetCode10();
        System.out.println(obj.isMatch1("aab","a*b"));

    }

    // 回溯
    //    如果没有星号（正则表达式中的 * ），问题会很简单——我们只需要从左到右检查匹配串 s 是否能匹配模式串 p 的每一个字符。
    //
    //    当模式串中有星号时，我们需要检查匹配串 s 中的不同后缀，以判断它们是否能匹配模式串剩余的部分。一个直观的解法就是用回溯的方法来体现这种关系。
    //
    //    作者：LeetCode
    //    链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        // 先判断第一位字符 是否匹配
        boolean first = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        // 判断是否存在 * 字符 进行处理
        // 如果没有 * 字符 依次判断即可
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // 分为 两种 情况
            // 1. * 匹配字符出现0次 匹配字符串后移
            // 2. * 匹配字符出现多次 原字符串依次匹配
            return (isMatch(text, pattern.substring(2)) ||
                    first && isMatch(text.substring(1), pattern));
        } else {
            return first && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    int[][] memo;
    //  动态规划 自顶向下的方法
    public boolean isMatch1(String text, String pattern) {
        memo = new int[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }
    // 记忆回溯 使用memo记忆状态 0为空 1为True 2为False
    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != 0) {
            return memo[i][j] == 1;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            // 记忆回溯 将状态保存入dp中
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? 1 : 2;
        return ans;
    }

    // 动态规划 自底向上
    public boolean isMatch2(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }


}
