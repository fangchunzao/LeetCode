package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/9 15:23
 **/
public class LeetCode238 {

    public static void main(String[] args) {
        LeetCode238 obj = new LeetCode238();
        System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{1,2,3,4})));
    }

    //对于题目是例子[1, 2, 3, 4]，想求出 3位置结果
    // ，我们要知道3位置前的乘积，和后面的乘积，即[1, 2] 和 [4]，所以我们用前缀积，和后缀积记录

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        // 每个索引位置 是 前面数字的乘积
        for (int i = 0; i < res.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        // k值为后面数字的乘积 res每个位置存放 前数字乘积 乘以 k（后面数字的乘积）
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }



}
