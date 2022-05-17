package com.leetcode.iv.offer;

/**
 * 面试题10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Offer10_2 {


    // 有一头牛，每年年初生一头小牛，每头小牛第四个年头每年年初也生一头小牛，按此规律，若无牛死亡，第N年有多少头牛？
    // n    1   2   3   4   5   6   7   8   9   10
    // res  2   3   4   6   9
    public Integer niu(int year) {
        if(year < 4){
            return year;
        }
        return niu(year - 1) + niu(year - 3);
    }

    public static void main(String[] args) {
        Offer10_2 obj = new Offer10_2();
        int aa = 10;
        System.out.println(obj.numWays1(aa));

    }
    // 动态规划
    public int numWays1(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        int a = 1, b = 1, sum = 0;
        for(int i = 2; i <= n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
