package com.leetcode.iv.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * description 面试题57 - II. 和为s的连续正数序列
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-03-06 14:16
 *
 * @since 2020-08-20 复习
 **/
public class Offer57_2 {

    // 滑动窗口 双指针
    public int[][] findContinuousSequence(int target) {
        if (target < 2) return new int[][]{};

        List<int[]> list = new ArrayList<>();

        int one = 1, two = 2;
        while (two <= target / 2 + 1 && one < two) {
            // 计算等差数列前N项和
            int sum = (one + two) * (two - one + 1) / 2;
            if (sum == target) {
                int[] r = new int[two - one + 1];
                for (int i = one, j = 0; i <= two; i++,j++) {
                    r[j] = i;
                }
                list.add(r);
                one++;
            } else if (sum < target)
                two++;
            else
                one++;
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // 间隔法
    // 等差数列求和公式为: (a1 + an) * n / 2  首项+尾项 * 项数  / 2
    // ∵每次递增的值为1 ∴ an = a1 + n - 1
    // 化简的 (2a1 + n - 1) * n / 2 = target
    // 由于 target已知, 我们只需要得出a1 和 n的值 就可以求出答案了
    // 可以直接遍历 从 0 -> n
    //    假设使用 a1 进行遍历，就需要遍历全部的值 与滑动窗口法差不多了
    //    如果使用 n 进行遍历， 那么时间复杂度会大大减小
    // 继续化简公式 a1 = (target - n(n-1)/2 ) / n
    //   当 (target - n(n-1)/2 ) % n 可以整除时 可计算出a1的值 就可以得出答案了
    //
    //作者：quantumdriver
    //链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/xiang-jie-hua-dong-chuang-kou-fa-qiu-gen-fa-jian-g/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[][] findContinuousSequence1(int target) {
        if (target < 2) return new int[][]{};

        List<int[]> list = new ArrayList<>();
        // n最小为2
        int n = 2;
        while (target >  n * (n-1)/2) {
            if ((target - (n * (n-1)/2)) % n == 0) {
                int a1 = (target - (n * (n-1)/2)) / n;
                int[] res = new int[n];
                for (int i = 0, v = a1; i < res.length; i++) {
                    res[i] = v++;
                }
                list.add(res);
            }
            n++;
        }
        Collections.reverse(list);
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
