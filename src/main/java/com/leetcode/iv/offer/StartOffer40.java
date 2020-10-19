package com.leetcode.iv.offer;


/**
 * 面试题40. 最小的k个数
 *
 * 寻找第K大
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @since 2020-08-25 复习
 *
 */
public class StartOffer40 {

    // 使用快排对数组进行排序 取出前K个值就行
    public int[] getLeastNumbers(int [] input, int k) {
        fastSort(input,0,input.length-1,k);
        int[] res = new int[k];
        for(int i = 0 ;i< k;i++){
            res[i] = input[i];
        }
        return res;
    }

    private void fastSort(int[] a,int low,int high,int k){
        if(low > high)return;
        int p = partation(a,low,high);
        if(p+1 == k){
            return;
        }else if(p+1 < k){
            fastSort(a,p+1,high,k);
        }else{
            fastSort(a,low,p-1,k);
        }
    }

    private int partation(int[] a,int low ,int high){
        // 取最后一个数作为基准数
        int privot = a[high];
        int i = low;
        for(int j = low;j < high;j++){
            // 从左侧挨个遍历
            if(a[j] < privot){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i,high);
        return i;
    }

    private void swap(int[] a ,int i ,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
