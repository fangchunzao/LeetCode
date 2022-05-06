package com.leetcode.iv.offer;

/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，
 * ……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @since 2020-08-18 复习
 */
public class Offer46 {

    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        char[] numCharStr = numStr.toCharArray();
        return translateNum(numCharStr, 0);
    }

    /**
     * 每一数字代表一个字母 从 0 -- 25
     * 2个数字可以组成一个小于25的数组 代表一个字母
     */
    public int translateNum(char[] numCharStr, int index) {
        if (numCharStr.length - 1 <= index)
            return 1;
        int count = 0;
        // 最大就是2位数
        // 一位数肯定可以 直接递归
        count += translateNum(numCharStr, index + 1);
        // 判断剩余够不够2位了
        if (numCharStr.length - 1 > index) {
            // 够2位 需要判断 2个数字是否小于 25
            if (numCharStr[index] - '0' == 0)
                return count;
            String chStr = String.valueOf(numCharStr[index] - '0') + String.valueOf(numCharStr[index+1] - '0');
            int chInt = Integer.parseInt(chStr);
            if (chInt <= 25)
                count += translateNum(numCharStr, index + 2);
        }
        return count;
    }

    // 动态规划
    // 分为两种情况
    //   1. 能构成双位数 dp[i] = dp[i - 1] + dp[i - 2]
    //   2. 不能构成 dp[i] = dp[i - 1]
    //
    public int translateNum1(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }


}
