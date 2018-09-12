package com.leetcode.algorithm.junior.string;

/**
 * @Auther: FCZ
 * @Description: 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * @Date: 2018/8/24 14:54
 */
public class String5 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int firstFlag  = 0,lastFlag = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            char firstChar = Character.toLowerCase(s.charAt(firstFlag));
            char lastChar = Character.toLowerCase(s.charAt(lastFlag));
            if (!((firstChar >= 'a' && firstChar <= 'z') || (firstChar >= '0' && firstChar <= '9'))) {
                firstFlag++;
                continue;
            }
            if (!((lastChar >= 'a' && lastChar <= 'z') || (lastChar >= '0' && lastChar <= '9'))) {
                lastFlag--;
                continue;
            }

            if (firstChar != lastChar) {
                return false;
            }
            firstFlag++;
            lastFlag--;
        }
        return true;

    }
}
