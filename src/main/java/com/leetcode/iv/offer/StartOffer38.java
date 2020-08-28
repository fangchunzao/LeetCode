package com.leetcode.iv.offer;

import java.util.*;

/**
 * 面试题38. 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * @since 2020-08-25 复习
 */
public class StartOffer38 {

    List<String> list = new ArrayList<>();
    // 回溯 替换 最优解
    public String[] permutation1(String s) {
        if(s == null) return new String[]{};

        char[] ch = s.toCharArray();
        dfs(ch, 0);
        return list.toArray(new String[list.size()]);
    }

    public void dfs(char[] ch, int start) {
        if (start == ch.length) {
            list.add(new String(ch));
            return;
        }
        boolean[] visited = new boolean[26];
        for (int i = start; i < ch.length; i++) {
            if (visited[ch[i] - 'a']) continue;
            visited[ch[i] - 'a'] = true;

            if (i != start)
                swap(ch, i, start);

            dfs(ch,start + 1);

            if (i != start)
                swap(ch, i, start);
        }
    }
    public void swap(char[] ch,int x,int y){
        char temp = ch[x];
        ch[x]=ch[y];
        ch[y]=temp;
    }



    // 回溯
    public String[] permutation(String s) {
        if(s == null) return new String[]{};
        Set<String> list = new HashSet<>();
        permutation(s, "", new boolean[s.length()], list);
        return list.toArray(new String[list.size()]);
    }

    public void permutation(String s, String str, boolean[] visited, Set<String> list) {
        if (str.length() == s.length()) {
            list.add(str);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            permutation(s, str + s.charAt(i), visited, list);
            visited[i] = false;
        }
    }


}
