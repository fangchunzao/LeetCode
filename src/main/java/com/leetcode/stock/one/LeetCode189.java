package com.leetcode.stock.one;

/**
 * 189. 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/29 10:26
 **/
public class LeetCode189 {

    public static void main(String[] args) {
        LeetCode189 obj = new LeetCode189();
        obj.rotate4(new int[]{-1,2,3,4,5,6,7}, 3);
    }

    // 暴力方法 最简单的方法是旋转 k 次，每次将数组旋转 1 个元素。
    public void rotate1(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    // 使用额外的数组
    // 我们可以用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。
    // 然后把新的数组拷贝到原数组中。
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    // 使用环状替换
    // 如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。
    // 因此，我们需要把被替换的数字保存在变量 temp 里面。
    // 然后，我们将被替换数字（temp）放到它正确的位置，并继续这个过程 n 次， n 是数组的长度。
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;  // 移动次数 当等于数组长度时 就处理完毕了
        // 如果数组长度为4 k=2 可以整除时， 会一直在位置 0->2 2->0 循环，无法到下一位， 因此使用一个for循环控制 当再次循环数 索引+1
        for (int start = 0; count < nums.length; start++) {
            // 前一个位置
            int pre = start;
            // 前一个数字
            int preValue = nums[start];
            do {
                // 下一位的位置
                int next = (pre + k) % nums.length;
                // 下一位的数字
                int nextValue = nums[next];
                // 数字替换
                nums[next] = preValue;
                preValue = nextValue;
                pre = next;
                // 替换次数+1
                count++;
            } while (start != pre);  // 当出现循环时 跳出 索引+1
        }
    }

    // 使用反转
    // 这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
    // 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k个元素，就能得到想要的结果。
    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }




}
