package com.leetcode.start;

/**
 * description
 *
 * @author FCZ
 * @since 2020-08-18 11:55:57
 */
public class 快速排序 {

    public int[] quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
        return input;
    }

    // 快速排序 模板
    public void quickSort(int[] input, int low, int high) {
        if (low >= high)
            return;
        int left = low, right = high;
        int point = input[low];
        while (left < right) {
            // 先从右边
            // 基准数在左侧 最后一步需要进行swap 将中间的数与基准替换 保证左侧都是小于等于基准数的
            // 如果先从左边开始 那么最后一个i++后 指向一个大于基准数的值 替换以后排序错误
            // 因此需要从右边开始 这样就能保证中间的数是小于基准数的

            // 如果想从左边开始 就需要使用右侧的基准数
            while (left < right && input[right] >= point)
                right--;

            while (left < right && input[left] <= point)
                left++;

            if (left < right) {
                swap(input, left, right);
            }
        }
        swap(input, left, low);
        // 分割
        quickSort(input, low, left - 1);
        quickSort(input, left + 1, high);
    }

    private void swap(int[] a ,int i ,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
