package com.leetcode.iv.must;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Must78 {

    public static void main(String[] args) {
        Must78 obj = new Must78();
        int[] nums = new int[]{1,2,3};
        obj.subsets(nums);
    }




    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();

        resList.add(new ArrayList<>());
        subsets(nums, 0, new ArrayList<>(), resList);

        return resList;
    }


    public void subsets(int[] nums, int index, List<Integer> list,List<List<Integer>> resList ) {
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            resList.add(new ArrayList<>(list));
            subsets(nums, i+1, list, resList);
            list.remove(list.size()-1);
        }

    }


}
