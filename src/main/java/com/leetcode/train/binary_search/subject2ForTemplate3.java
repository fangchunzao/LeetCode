package com.leetcode.train.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 找到 K 个最接近的元素
 *
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * 示例 1:
 *
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 */
public class subject2ForTemplate3 {

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,2,3,6,8,8,9};
        System.out.println(findClosestElements(arr,5,9));
    }
    // 先通过二分查找 找到与x差值最小的数
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left = 0, right = arr.length - 1, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                break;
            } else if (arr[mid] > x){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 然后从mid 的左右遍历值，找到符合条件的
        list.add(arr[mid]);
        int leftIndex = 1,rightIndex = 1;
        while (list.size() < k) {
            if (mid < leftIndex) {  //当左下标移动到了最左边 不计算 直接将右边元素加入
                list.add(arr[mid + rightIndex]);
                rightIndex++;
                continue;
            }
            if (mid + rightIndex > arr.length - 1) {  //当右下标移动到了最右边 不计算 直接将左边元素加入
                list.add(arr[mid - leftIndex]);
                leftIndex++;
                continue;
            }
            // 正常情况 比较左下标与右下标与值差的绝对值的大小
            int leftABS = Math.abs(x - arr[mid - leftIndex]);
            int rightABS = Math.abs(x - arr[mid + rightIndex]);
            if (leftABS <= rightABS) {
                list.add(arr[mid - leftIndex]);
                leftIndex++;
            } else {
                list.add(arr[mid + rightIndex]);
                rightIndex++;

            }
        }
        Collections.sort(list);
        return list;
    }

}
