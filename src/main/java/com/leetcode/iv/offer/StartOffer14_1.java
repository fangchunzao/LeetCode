package com.leetcode.iv.offer;

/**
 * 面试题14- I. 剪绳子
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 *
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class StartOffer14_1 {

    int[] memory;

    public static void main(String[] args) {
        StartOffer14_1 obj = new StartOffer14_1();

        System.out.println(obj.integerBreak3(5));
    }

    public int integerBreak(int n) {
        memory = new int[n + 1];
        return integerBreakHelper(n);
    }
    public int integerBreakHelper(int n) {
        if (n == 2) {
            return 1;
        }
        // 记忆化的核心 保存 n 对应的最大长度
        if (memory[n] != 0) {
            // memory的初始值为0，如果它不为0，说明已经计算过了，直接返回即可
            return memory[n];
        }
        int res = -1;
        // i 为分割的长度
        for (int i = 1; i < n; i++) {
            // 以i长度 分割后 到 末尾最大值 相乘
            int sum1 = i * (n - i);
            // 以i长度 分割后 剩余的长度能分割的最大长度
            int sum = i * integerBreakHelper(n - i);
            int maxS = Math.max(sum, sum1);
            res = Math.max(res, maxS);
        }
        memory[n] = res;
        return res;
    }

    // 动态规划 由记忆回溯推导出
    public int integerBreak3(int n) {
        memory = new int[n + 1];
        memory[2] = 1;
        // i 为当前长度
        for (int i = 3; i <= n; i++) {
            // j为分割长度
            for (int j = 1; j < i; j++) {
                // j * (i - j)  以 j长度 分割后 到 末尾最大值 相乘
                // j * memory[i - j] 以i长度 分割后 剩余的长度能分割的最大长度 i-j 的位置保存之前计算好的值
                memory[i] = Math.max(memory[i], Math.max(j * memory[i - j], j * (i - j)));
            }
        }
        return memory[n];
    }


    // 贪心法 分割长度3 效益最高 尽量分割为3
    public int cuttingRope1(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3,
                b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

}
