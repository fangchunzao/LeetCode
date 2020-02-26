package com.leetcode.stock.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCode46 {

    public static void main(String[] args) {
        LeetCode46 obj = new LeetCode46();
        obj.permute(new int[] {1,2,3,4});
        //                      [1,2,3,4],
        //                      [1,2,4,3],
        //                      [1,3,2,4],
        //                      [1,3,4,2],
        //                      [1,4,2,3],
        //                      [1,4,3,2],

    }

    public List<List<Integer>> permute(int[] nums) {
        return null;
    }

    List<List<Integer>> result = new ArrayList<>();

    public void permute(int[] nums, int index, List<Integer> list) {
        if (index >= nums.length - 1) {
            result.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            permute(nums, ++index, list);
            list.remove(nums[i]);
        }
    }

}
