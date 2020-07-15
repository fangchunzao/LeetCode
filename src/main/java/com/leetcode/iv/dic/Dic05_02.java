package com.leetcode.iv.dic;

/**
 * description 面试题 05.02. 二进制数转字符串
 *
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 * 如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 示例1:
 *
 *  输入：0.625
 *  输出："0.101"
 * 示例2:
 *
 *  输入：0.1
 *  输出："ERROR"
 *  提示：0.1无法被二进制准确表示
 * 提示：
 *
 * 32位包括输出中的"0."这两位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bianry-number-to-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-07-15 14:23
 */
public class Dic05_02 {

    public static String printBin(double num) {
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }
        // 转二进制
        StringBuilder res = new StringBuilder("0.");
        while (num != 0) {
            num *= 2;
            // 去除整数位 判断是否可以转二进制
            double tempNum = num - (int)num;
            if (tempNum == 0.2)
                return "ERROR";

            if (num >= 1)
                res.append("1");
            else
                res.append("0");
            // 保存 去掉整数部分的结果
            num = tempNum;
            if (res.length() >= 34)
                return "ERROR";
        }
        return res.toString();
    }


}
