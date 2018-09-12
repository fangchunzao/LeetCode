package com.leetcode.algorithm.junior.string;

/**
 * @Auther: FCZ
 * @Description: 数数并说
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 * 8.     1113213211
 * 9.     31131211131221
 * 10.    13211311123113112211
 * @Date: 2018/9/11 14:21
 */
public class String8 {

    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }

    //需要我们把数字的值(value)与连续位数(count)记录下来，当数字发生变化时追加连续位数与值到结果中即可。
    public static String countAndSay(int n) {
        if (n <= 0) return "-1";
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            int index = 0;
            while (index < result.length()) {
                char value = result.charAt(index); // 当前值
                int count = 0;  // 记录连续位数
                // 查找连续位数，碰到不相同的数字时停止。
                while (index < result.length() && result.charAt(index) == value) {
                    index++;
                    count++;
                }
                builder.append(String.valueOf(count)).append(value);
            }
            result = builder.toString();
        }
        return result;
    }
}
