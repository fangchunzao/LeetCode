package com.leetcode.iv.offer;

import java.util.Arrays;

/**
 * description 面试题56 - I. 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since  2020-06-08 10:25
 *
 * @since 2020-08-20 复习
 **/
public class Offer56_1 {

    public static void main(String[] args) {

        Offer56_1 obj = new Offer56_1();
        int[] nums = new int[]{1,2,5,2};
        System.out.println(Arrays.toString(obj.singleNumbers(nums)));
    }

    // 把所有数字异或，得到一个数，这个数必定是两个只出现一次的数字异或得到的
    // 异或规则是两个相应的bit位相同为0，不同为1
    // 根据这个任意找一个为1的数位
    // 根据这个数位为0和1分成两个数组
    // 这样必定把两个结果数分开了，再分别异或就能得到结果
    public int[] singleNumbers(int[] nums) {
        int sum=0;
        // 将数组所有元素进行异或，最后的结果一定是那两个单一数字的异或结果
        for (int num : nums) {
            sum ^= num;
        }
        int first = 1;
        // 通过与运算找到异或结果中首个1 因为异或结果中1代表两数字二进制该位不同
        while((sum & first)==0){
            first=first<<1;
        }
        // 我们可以根据数组元素的二进制低位第一位是否为1，将数组分为2类，
        // 此时再将两个数组两两异或就可以得到最终结果。
        int[] result = new int[2];
        for (int num : nums) {
            // first的特殊性使用0判断不能使用1 &计算完的值== first 不是==1
            if ((num & first) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
