package com.leetcode.stock.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/11/22 09:40
 **/
public class LeetCode15 {

    public static void main(String[] args) {

    }

    // 暴力法 暴力循环判断

    // 排序 双指针
    //         作者：jyd
    //        链接：https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
    //        来源：力扣（LeetCode）
    //        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 固定 3 个指针中最左（最小）数字的指针 k，双指针 i，j 分设在数组索引 k,len(nums) 两端
        for(int k = 0; k < nums.length - 2; k++){
            // nums[j] >= nums[i] >= nums[k] > 0，即 3个数字都大于 0
            if(nums[k] > 0) break;
            // 因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            // 初始化 i 和 j 一前一后
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                // 使用 while 循环 将 相同元素跳过
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

}
