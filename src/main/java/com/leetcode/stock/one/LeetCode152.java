package com.leetcode.stock.one;

/**
 * 152. 乘积最大子序列
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/28 09:41
 **/
public class LeetCode152 {

    public static void main(String[] args) {
        LeetCode152 obj = new LeetCode152();
        int max = obj.maxProduct(new int[] {2,3,-2,4,-1,8});
        System.out.println(max);
    }

    // 动态规划
    // 遍历数组时计算当前最大值，不断更新
    // 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
    // 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
    // 当负数出现时则imax与imin进行交换再进行下一步计算
    // 时间复杂度：O(n)O(n)
    public int maxProduct(int[] nums) {
        // 同时记录 每次的 最大值和最小值 当出现负数时 最大值即变成最小值
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            // 判断当前乘积 与 当前数字 的最大值
            imax = Math.max(imax*nums[i], nums[i]);
            // 判断当前乘积 与 当前数字 的最小值
            imin = Math.min(imin*nums[i], nums[i]);
            // 最大值
            max = Math.max(max, imax);
        }
        return max;
    }


}
