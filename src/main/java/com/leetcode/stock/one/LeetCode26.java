package com.leetcode.stock.one;

/**
 *
 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class LeetCode26 {

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int number = 0;//标记计数
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != nums[number]) {
                number++;
                nums[number] = nums[i];
            }
        }
        number += 1; //标记 +1 即为数字个数
        return number;

    }

}
