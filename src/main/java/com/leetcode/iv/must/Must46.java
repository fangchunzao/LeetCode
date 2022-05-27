package com.leetcode.iv.must;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 46. 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Must46 {

    public static void main(String[] args) {
        Must46 obj = new Must46();
        int[] nums = new int[]{1,2,3};
        obj.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        permute(nums, 0, new ArrayList<>(), resList);
        return resList;
    }

    public void permute(int[] nums, int index ,List<Integer> list,List<List<Integer>> resList) {
        if (nums.length == index) {
//            resList.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            resList.add(new ArrayList<>(list));
            return;
        }
        // [1,2,3]
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            if (i != index) {
                swap(nums, i, index);
            }

            permute(nums, index + 1, list, resList);

            if (i != index) {
                swap(nums, i, index);
            }
            list.remove(list.size() - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }



}
