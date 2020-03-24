package com.leetcode.iv.dic;

/**
 * @author fcz
 * @description  面试题 17.16. 按摩师
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020-03-24 09:44
 **/
public class IV17_16 {

    public static void main(String[] args) {
        IV17_16 obj = new IV17_16();
        System.out.println(obj.massage(new int[]{2,7,9,3,1}));
    }

    // 动态规划 原数组上计算
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        nums[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-2], nums[i-3]);
        }
        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }

    // 动态规划 原数组上计算
    public int massage2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1], nums[i-2] + nums[i]);
        }
        return nums[nums.length - 1];
    }

    // 动态规划 使用两个变量
    public int massage1(int[] nums) {
        // 2 1 1 2
        // 1. c=2 a=0 b=2
        // 2. c=2 a=2 b=2
        // 3. c=3 a=2 b=3
        // 4. c=4 a=3 b=4
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);

            a = b;
            b = c;
        }
        return b;
    }

}
