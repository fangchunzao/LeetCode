package com.leetcode.stock.one;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 350. 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/4 11:30
 **/
public class LeetCode350 {

    public static void main(String[] args) {
        int[] a1 = {4,9,5};
        int[] a2 = {9,4,9,8,4};
        // System.out.println(Arrays.toString(intersect(a1,a2)));
        System.out.println(Arrays.toString(intersect1(a1, a2)));
    }

    // 哈希表
    // 先用Hashmap记录第一个数组中的元素【放在key】，和出现的次数【放在value】。
    //
    //然后再遍历第二个数组，如果找到对应元素，则添加这个元素到返回数组里。
    //
    //如果value值大于1，HashMap中的value值减 1，表示已经找到一个相同的了。
    //
    //如果value值等于1，则删除该元素。
    //
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums1) {
            if (hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }

        }
        List<Integer> result = new ArrayList<>();
        for(int num : nums2) {
            if (hashMap.containsKey(num)){
                result.add(num);
                int n = hashMap.get(num);
                if (n > 1)
                    hashMap.put(num, --n);
                else
                    hashMap.remove(num);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    // 排序 双指针
    // 如果相等，元素push到返回值里，两个指针同时往前
    // 哪一个元素小 它所在的数组 指针往前
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
