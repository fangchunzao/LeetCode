package com.leetcode.iv.dic;

/**
 * description 面试题 10.03. 搜索旋转数组
 *
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 *  输出: 8（元素5在该数组中的索引）
 * 示例2:
 *
 *  输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 *  输出：-1 （没有找到）
 * 提示:
 *
 * arr 长度范围在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-rotate-array-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-08-01 16:04:12
 */
public class StartDic10_03 {

    // 二分查找
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            /*
             * 通过中点与左侧点对比分为三种情况
             * 1. 中 > 左 左侧递增 旋转点在右侧
             *    判断target是否在 left - mid 区间内 需要判断 == 的情况
             *
             * 2. 中 < 左 旋转点在左侧 右侧递增
             *    判断target是否在mid - right区间 不需要判断 == 情况 (因为返回相同最左侧的)
             *
             * 3. 中 = 左 找到目标值 或者为重复值 目标值在左侧或者右侧
             *
             */
            if (arr[mid] > arr[left]){
                // 左侧递增 旋转点在右侧
                // 判断target是否在 left - mid 区间内
                if (target >= arr[left] && target <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < arr[left]) {
                // 中 < 左 旋转点在左侧 右侧递增
                // 判断target是否在 mid - right 区间内
                if (target > arr[mid] && target < arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }

                // 也可以通过判断左侧区间的方式
             /*   if (target >= arr[left] || target <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }*/
            } else {
                // 相等 找到目标值 或者为重复值
                if (target == arr[left]) {
                    return left;
                } else {
                   left ++;
                }
            }
        }
        // [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14]
        return (arr[left] == target) ? left : -1;
    }

}
