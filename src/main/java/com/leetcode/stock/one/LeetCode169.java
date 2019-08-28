package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * 169. 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/13 11:11
 **/
public class LeetCode169 {

    public static void main(String[] args) {
        LeetCode169 oj = new LeetCode169();

        int a[] = {6,5,5};

        System.out.println(oj.majorityElement2(a));
    }

    // Boyer-Moore 投票算法
    // 如果我们把众数记为 +1+1 ，把其他数记为 -1−1 ，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多。
    // [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
    //
    //首先，下标为 0 的 7 被当做众数的第一个候选。在下标为 5 处，计数器会变回0 。所以下标为 6 的 5 是下一个众数的候选者。由于这个例子中 7 是真正的众数，所以通过忽略掉前面的数字，我们忽略掉了同样多数目的众数和非众数。因此， 7 仍然是剩下数字中的众数。
    //
    //[7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 5, 5, 5, 5]
    //
    //现在，众数是 5 （在计数器归零的时候我们把候选从 7 变成了 5）。此时，我们的候选者并不是真正的众数，但是我们在 遗忘 前面的数字的时候，要去掉相同数目的众数和非众数（如果遗忘更多的非众数，会导致计数器变成负数）。
    //
    //因此，上面的过程说明了我们可以放心地遗忘前面的数字，并继续求解剩下数字中的众数。最后，总有一个后缀满足计数器是大于 0 的，此时这个后缀的众数就是整个数组的众数。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // 排序 中间的就是
    public static int majorityElement0(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 还可以使用Hash表 实现比较简单

    // 先排序 判断每个数据出现的次数 (笨方法) 当排序完成后，中间的数字就是众数
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1, // 总次数
                preNum = nums[0],  // 上一个数字
                numCount = 1,      // 当前数字出现的次数
                result = nums[0];  // 结果数字
        for (int i = 1; i < nums.length; i++) {
            if (preNum != nums[i]) {
                // 如果数字不同 需要重新计数
                preNum = nums[i];
                numCount = 1;
            } else {
                // 当前数字出现的次数+1
                numCount++;
            }
            // 如果当前数字出现的次数最大 作为结果
            if (numCount > count) {
                count = numCount;
                result = nums[i];
            }
        }
        return result;
    }


    // 使用分治算法
    // 判断出左侧众数 和 右侧的众数 然后判断谁大
    public static int majorityElement1(int[] nums) {
        return majorityElement1(nums, 0, nums.length-1);
    }

    private static int majorityElement1(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        if (lo == hi) {
            return nums[lo];
        }

        // 从中点分割为两个数组
        int mid = (hi-lo)/2 + lo;
        int left = majorityElement1(nums, lo, mid);
        int right = majorityElement1(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // 计算左右数组的个数
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }


    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
