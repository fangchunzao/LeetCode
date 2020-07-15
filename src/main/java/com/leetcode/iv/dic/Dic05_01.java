package com.leetcode.iv.dic;

/**
 * description 面试题 05.01. 插入
 *
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。
 * 编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束
 * 假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。
 * 例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 *
 * 示例1:
 *
 *  输入：N = 10000000000, M = 10011, i = 2, j = 6
 *  输出：N = 10001001100
 * 示例2:
 *
 *  输入： N = 0, M = 11111, i = 0, j = 4
 *  输出：N = 11111
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-15 10:34
 */
public class Dic05_01 {

    public static int insertBits(int N, int M, int e, int k) {
        // 从右往左 依次计算
        int ans = 0;
        for (int i = 0; i <= 31;) {
            if (i == k) {
                for (int j = 0; j <= e-k; j++) {
                    // 这里的| 可以换成^ 计算结果一致
                    // ans每一位都是0
                    ans |= (M >> j & 1) << i;
                    i++;
                }
            } else {
                // 将N的第i位补到ans中
                ans |= (N >> i & 1) << i;
                i++;
            }
        }
        return ans;
    }


    public static int insertBits1(int N, int M, int k, int e) {
        int ans   = 0;
        for(int i = 0;i <= 31;i ++){
            if(i == k){
                for(int j = 0; j <= e - k; j++){
                    ans ^= (M >> j & 1) << i;
                    if(j != e - k) i ++; // 最后一次不用加，不然会跳位！
                }
            }
            else ans ^= (N >> i & 1) << i;
        }
        return ans;
    }

}
