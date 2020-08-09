package com.leetcode.iv.dic;

/**
 * description 面试题 16.16. 部分排序
 *
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，
 * 若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 *
 * 示例：
 *
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 提示：
 *
 * 0 <= len(array) <= 1000000
 * 通过次数4,626提交次数10,651
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sub-sort-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-08-09 16:41:28
 */
public class Dic16_16 {

    public int[] subSort(int[] array) {
        if(array == null || array.length == 0) return new int[]{-1, -1};
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;

        // 前后一起遍历 判断最大值最小值所在的位置 如果不是有序的
        for(int i = 0; i < len; i++){
            if(array[i] < max){
                last = i;
            }else{
                max = Math.max(max, array[i]);
            }

            if(array[len - 1 - i] > min){
                first = len - 1 - i;
            }else{
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[] {first, last};
    }


    public int[] subSort1(int[] array) {
        if (array == null || array.length == 0)
            return new int[]{-1,-1};
        // 如果数组存在无序数列 找出无序数列中的最大值和最小值
        boolean isSort = false;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, tempMax = array[0];
        for (int i = 1; i < array.length; i++) {
            // 出现无序 保存当前的最大值
            if (array[i] < tempMax) {
                isSort = true;
                max = Math.max(max, tempMax);
                min = Math.min(min, array[i]);
            } else {
                // 有序状态 赋值最大值
                tempMax = array[i];
            }

        }
        if (!isSort)
            return new int[]{-1, -1};
        int left = 0, right = array.length - 1;
        while (array[left] <= min) {
            left++;
        }
        while (array[right] >= max){
            right--;
        }
        return new int[]{left, right};
    }


}
