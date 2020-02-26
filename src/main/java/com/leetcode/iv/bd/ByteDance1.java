package com.leetcode.iv.bd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ByteDance1 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int n = s.length();

        Set<Character> existChar = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!existChar.contains(s.charAt(j))) {
                existChar.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                existChar.remove(s.charAt(i++));
            }
        }
        return max;
    }

}
