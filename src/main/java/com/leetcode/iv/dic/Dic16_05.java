package com.leetcode.iv.dic;

/**
 * description 面试题 16.05. 阶乘尾数
 *
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-zeros-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-08-06 15:18
 */
public class Dic16_05 {

    // 所有的0都是由5提供的 只要存在一个5 肯定能出来一个0 因此使用 n/5 可以找出存在多少个5
    // 25 = 5 * 5 由2个5构成 可以出现2个0
    // 125 = 5 * 5 * 5 由3个5构成 可以出现3个0
    // count = n / 5 + n / 5 / 5 + n / 5 / 5 / 5 + ...
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

}
