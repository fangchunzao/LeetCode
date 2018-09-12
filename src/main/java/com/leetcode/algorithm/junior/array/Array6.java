package com.leetcode.algorithm.junior.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  两个数组的交集 II
 *
 *   给定两个数组，写一个方法来计算它们的交集。
 *   例如:
 *   给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 */
public class Array6 {

    public static void main(String[] args) {
        int[] a1 = {1,2,2,1,5,3,4};
        int[] a2 = {1,2,2,4};
       // System.out.println(Arrays.toString(intersect(a1,a2)));
        System.out.println(Arrays.toString(intersect(new int[10], new int[20])));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int n1 = 0, n2 = 0; n1 < nums1.length && n2 < nums2.length;) {
            if(nums1[n1] < nums2[n2]) {
                n1++;
            } else if (nums1[n1] > nums2[n2]) {
                n2++;
            } else {
                result.add(nums1[n1]);
                n1++;
                n2++;
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
