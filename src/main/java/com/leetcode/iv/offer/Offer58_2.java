package com.leetcode.iv.offer;

/**
 * description  面试题58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since  2020-06-09 10:41
 *
 * @since 2020-08-24 复习
 **/
public class Offer58_2 {

    /**
     * 遍历并计算位置
     * 时间复杂度 O(N) ： 线性遍历 s 并添加，使用线性时间
     * 空间复杂度 O(N) ： 新建的辅助 res 使用 O(N) 大小的额外空间
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }


    /**
     * 直接切割字符串合并
     * 时间复杂度 O(N) ： 其中 N 为字符串 s 的长度，字符串切片函数为线性时间复杂度
     * 空间复杂度 O(N) ： 两个字符串切片的总长度为 NN。
     */
    public String reverseLeftWords3(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 原地算法
     * 挨个移动数字 计算下一个数字的位置 （效率较低）
     * 左旋 就是 字符串向右移动的距离 = 数组长度 - 左旋距离
     */
    public static String reverseLeftWords4(String s, int n) {
        int length = s.length();
        // 右移的距离
        int rightMove = length - n;
        char[] strChar = s.toCharArray();
        int count = 0;
        for (int i = 0; i < strChar.length && count < strChar.length; i++) {
            int preIndex = i;
            char preValue = strChar[preIndex];
            do  {
                int nextIndex = (preIndex + rightMove) % length;
                char nextValue = strChar[nextIndex];
                // 替换
                strChar[nextIndex] = preValue;
                preIndex = nextIndex;
                preValue = nextValue;
                count++;
            } while (preIndex != i && count <= strChar.length);
        }
        return new String(strChar, 0, length);
    }

}

