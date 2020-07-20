package com.leetcode.iv.dic;

import java.util.ArrayList;
import java.util.List;

/**
 * description 面试题 08.04. 幂集
 *
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-17 10:43
 */
public class Dic08_04 {

    public static void main(String[] args) {
        Dic08_04 obj = new Dic08_04();
        obj.subsets1(new int[]{1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, new ArrayList<>());
        resList.add(new ArrayList<>());
        return resList;
    }

    List<List<Integer>> resList = new ArrayList<>();
    public void subsets(int[] nums, int left, List<Integer> list) {
        if (left >= nums.length)
            return;

        for (int i = left; i < nums.length; i++) {
            list.add(nums[i]);
            resList.add(new ArrayList<>(list));
            subsets(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    // 位图法
    // 例如 [1, 2, 3] 有三位可以从 0 遍历到 7 也就是 2 ^ 3 - 1 中排列方式
    // 用二进制表示就是 000, 001, 010, 011, 100, 101, 110, 111 正好代表了全部子集
    // 第i位可以表示元素是否在集合中的“布尔”标志
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int bmp = (int) Math.pow(2, nums.length);
        // 从 nums.length 个 0 遍历到 nums.length 个 1
        for (int i = 0; i < bmp; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                // 将每一位右移最低位，检测其是否为1
                if ((i >>> j & 1) == 1) subset.add(nums[j]);
            subsets.add(subset);
        }
        return subsets;
    }





























    // 11 3
    // 110 6
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
//        int binaryLength = (int)Math.pow(2, nums.length);
        int binaryLength =  nums.length << 1;
        for (int i = 0; i < binaryLength; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i >>> j & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            resList.add(list);
        }
        return resList;
    }


}
