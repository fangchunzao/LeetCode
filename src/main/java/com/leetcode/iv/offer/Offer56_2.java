package com.leetcode.iv.offer;

/**
 * description 面试题56 - II. 数组中数字出现的次数 II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 *
 * 限制：
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since  2020-06-08 10:25
 *
 * @since 2020-08-20 复习
 **/
public class Offer56_2 {

    /**
     * 位运算
     * 使用二进制的方式，对于出现3次的数字，各 二进制位 出现的次数都是 3 的倍数
     * 因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        // int为32数字
        // 保存各二进制位1出现的次数
        int[] resArray = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                resArray[i] += num & 1;
                // >>> 高位补0  >> 负数高位补1
                num >>>= 1;
            }
        }
        // 每一位对3取余后 就是结果 使用 | 运算保存结果
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= resArray[31 - i] % 3;
        }
        return res;
    }

    // 使用hash表计算出现次数 实现简单不写了


    /**
     * 最优解 有限状态自动机 太难了
     *
     * 各二进制位的 位运算规则相同 ，因此只需考虑一位即可
     * 对于所有数字中的某二进制位 1 的个数，存在 3 种状态，即对 3 余数为 0, 1, 2
     *
     * 若输入二进制位 1，则状态按照以下顺序转换
     *      0→1→2→0→⋯
     * 若输入二进制位 0，则状态不变
     *
     * 由于二进制只能表示 0, 1
     * 因此需要使用两个二进制位来表示 3 个状态
     * 设此两位分别为 two, one，则状态转换变为：
     *      00→01→10→00→⋯
     *
     * 接下来，需要通过 状态转换表 导出 状态转换的计算公式 。
     * 首先回忆一下位运算特点，对于任意二进制位 xx ，有：
     *
     * 异或运算：x ^ 0 = x​ ， x ^ 1 = ~x
     * 与运算：x & 0 = 0 ， x & 1 = x
     *
     */
    public int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }


}
