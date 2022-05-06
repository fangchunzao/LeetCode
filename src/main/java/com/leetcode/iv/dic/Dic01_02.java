package com.leetcode.iv.dic;

/**
 * description 面试题 01.02. 判定是否互为字符重排
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-06-29 20:34:06
 */
public class Dic01_02 {


    // 哈希表
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        // char的字符最大为127
        int[] hashTable = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            hashTable[s1.charAt(i)]++;
            hashTable[s2.charAt(i)]--;
        }
        for(int count : hashTable) {
            if (count != 0)
                return false;
        }
        return true;
    }

    // 通过ASCII码计数比较
    public boolean CheckPermutation1(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum1 += s1.charAt(i);
            sum2 += s2.charAt(i);
        }
        return sum1 == sum2;
    }

    public static void main(String[] args) {
        System.out.println((int)'a' + (int)'z');
        System.out.println((int)'b' + (int)'y') ;
        Dic01_02 dic = new Dic01_02();
        boolean flag = dic.CheckPermutation1("az", "by");
        System.out.println(flag);
    }

}
