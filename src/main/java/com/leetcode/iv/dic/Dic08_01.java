package com.leetcode.iv.dic;

/**
 * description 面试题 08.01. 三步问题
 *
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-16 14:57
 */
public class Dic08_01 {
    public static void main(String[] args) {
        System.out.println(1000000007);
        System.out.println(1000000007*2);
        System.out.println(1000000007*3);
    }

    // 动态规划
    // 1 1  1+0+0
    // 2 2  1+1+0
    // 3 4  2+1+1
    // 4 7  4+2+1
    // 5 13 7+4+2
    // 6 24 13+7+4
    //
    // f(n) = f(n-1)+f(n-2)+f(n-3)
    public int waysToStep(int n) {
        if (n <= 2)
            return n;
        int n0 = 0;
        int n1 = 1;
        int n2 = 2;
        int res = -1;
        for (int i = 3; i <= n; i++) {
            res = (n0 + n1) % 1000000007;
            res = (res + n2) % 1000000007;
            n0 = n1 % 1000000007;
            n1 = n2 % 1000000007;
            n2 = res ;
        }
        return res % 1000000007;
    }

}
