package com.leetcode.train.binary_search;

/**
 * @Description: 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 */
public class subject3ForTemplate2 {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7,0};
        int[] nums = {1,3,3};
        System.out.println(findMin(nums));
    }

    /**
     * 对于数组 [0,1,2,4,5,6,7] 共有其中7中旋转方法
     * 0　　1　　2　　4　　5　　6　　7
     * 7　　0　　1　　2　　4　　5　　6
     * 6　　7　　0　  1　　2　　4　　5
     * 5　　6　　7　　0　　1　　2　　4
     * 4　　5　　6　　7　　0　　1　　2
     * 2　　4　　5　　6　　7　　0　　1
     * 1　　2　　4　　5　　6　　7　　0
     * 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的
     * 如果右半段有序，则最小数肯定出现在左侧（包含中点），同理，左半段有序，最小数在右侧
     *
     * 哪边数组是有序的，最小值就在另一边
     */
    public static int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) { //右侧升序 在包含中间的左侧
                right = mid;
            } else { // 左侧升序 肯定在右侧
                left = mid + 1;
            }
        }
        return nums[left];
    }
    // 如果相同即为重复数字，去掉就可以了
    public int findMin2(int[] nums) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) // 完全升序情况
            return nums[left];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) { //右侧升序 在包含中间的左侧
                right = mid;
            } else if (nums[mid] > nums[right]){ // 左侧升序 肯定在右侧
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

}
