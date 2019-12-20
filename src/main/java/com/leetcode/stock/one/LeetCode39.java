package com.leetcode.stock.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @description
 * @date 2019-12-20 15:53z`
 **/
public class LeetCode39 {

    public static void main(String[] args) {
        LeetCode39 obj = new LeetCode39();
        obj.combinationSum(new int[]{2,3,5}, 8);
    }

    // 计算元素和 回溯判断
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, 0, new ArrayList<>());
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    public void combinationSum(int[] candidates, int target, int index, List<Integer> list) {
        // 计算当前List的值 是否与target相同
        int sum = 0;
        for (Integer num : list)
            sum += num;
        // 与target相同保存入结果
        if (sum == target) {
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (; index < candidates.length; index++) {
            // 如果未达到target 继续增加当前index位置数字
            if (sum < target) {
                list.add(candidates[index]);
                combinationSum(candidates, target, index, list);
            } else {
                // 如果超出target 就不需要继续增加了 删除当前数字 继续下一位数字
                list.remove(list.size() - 1);
                return;
            }
        }
        if (list.size() != 0) {
            list.remove(list.size() - 1);
        }
    }

    // 递减target 回溯判断
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序后 可减少判断次数
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            // 不够减了 不用继续下去了 直接break
            if (target < candidates[start]) break;
            // 增加一位 继续计算
            tmp_list.add(candidates[start]);
            // 对target进行减法运算
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            // 删除最后一个元素
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

}
