package com.leetcode.stock.one;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/10/31 10:10
 **/
public class LeetCode179 {

    public static void main(String[] args) {
        LeetCode179 obj = new LeetCode179();
        System.out.println(obj.largestNumber(new int[]{3,30,34,5,9}));
    }

    public String largestNumber(int[] nums) {
        // step.1 将数字数组转成字符串数组
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        // step.2 对字符串进行排序 两个数字连接 谁大放前面
        Arrays.sort(asStrs, new LargerNumberComparator());
        // 如果最大的数字为0 直接返回0
        if (asStrs[0].equals("0")) {
            return "0";
        }
        // step.3 构造出最大数字
        String largestNumberStr = "";
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            System.out.println(order2.compareTo(order1));
            return order2.compareTo(order1);
        }
    }

}
