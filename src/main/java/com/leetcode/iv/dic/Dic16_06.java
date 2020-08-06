package com.leetcode.iv.dic;

import java.util.Arrays;

/**
 * description 面试题 16.06. 最小差
 *
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * 示例：
 *
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 * 提示：
 *
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间[-2147483648, 2147483647]内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-difference-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-08-06 15:38
 */
public class Dic16_06 {

    // 排序后双指针判断
    public int smallestDifference2(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long min = Long.MAX_VALUE;
        for (int i = 0, j = 0; i < a.length && j < b.length;) {
            if (a[i] == b[j])
                return 0;
            if (a[i] < b[j]) {
                min = Math.min(min, (long)b[j] - a[i]);
                i++;
            } else {
                min = Math.min(min, (long)a[i] - b[j]);
                j++;
            }
        }
        return (int)min;
    }
    // 排序后二分查找
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(b);
        long res = Long.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            // 通过二分查找 找到距离a[i]值最近的 趋近于右侧的值
            int index = binarySearch(b, a[i]);
            // 存在情况 b 数组中的值 全部小于a[i] 那么index = b数组长度
            if (index != b.length) {
                long diff = Math.abs((long)(a[i] - b[index]));
                res = Math.min(res, diff);
            }
            // 存在情况 b 数组中的值 全部大于a[i] 那么index = 0
            if (index != 0) {
                long diff = Math.abs((long)(a[i] - b[index - 1]));
                res = Math.min(res, diff);
            }
        }
        return (int)res;
    }

    private int binarySearch(int[] array, int num) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = left + (left + right) / 2;
            if (array[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }



}
