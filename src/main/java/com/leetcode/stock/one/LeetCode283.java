package com.leetcode.stock.one;

/**
 *
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author Mr.F
 * @since 2019/9/3 10:22
 **/
public class LeetCode283 {

    public static void main(String[] args) {
    }

    public void moveZeroes1(int[] nums) {
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                nums[i - zeroCount] = nums[i];
            }
        }
        for (int i = nums.length - zeroCount; i < nums.length; i++){
            nums[i] = 0;
        }

    }

    // 定义两个指针i,j，然后遍历数组，i跟j同时往前走，当遇到0时j停下，i继续往前走。
    // 当nums[i]不为0时则将num[i]的元素赋给j的位置，j++,nums[i]被赋值为0
    public void moveZeroes2(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroIndex != i) {
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                }
                zeroIndex++;
            }
        }
    }

}
