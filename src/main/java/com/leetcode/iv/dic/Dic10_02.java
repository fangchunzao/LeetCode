package com.leetcode.iv.dic;

import java.util.*;

/**
 * description 面试题 10.02. 变位词组
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-08-01 15:28:15
 */
public class Dic10_02 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String key = new String(strChar);
            List<String> list = hashMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            hashMap.put(key, list);
        }
        return new ArrayList<>(hashMap.values());
    }


    // 暴力法
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> resList = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;

            List<String> list = new ArrayList<>();
            list.add(strs[i]);

            char[] strChat1 = strs[i].toCharArray();
            for (int j = i + 1; j < strs.length; j++) {
                if (visited[j])
                    continue;
                char[] strChat2 = strs[j].toCharArray();
                if (strChat1.length != strChat2.length)
                    continue;
                if (isSame(strChat1, strChat2)) {
                    visited[j] = true;
                    list.add(strs[j]);
                }
            }
            resList.add(list);
        }
        return resList;
    }

    private boolean isSame(char[] str1, char[] str2) {
        int[] exist = new int[26];
        for (int i = 0; i < str1.length; i++) {
            exist[str1[i] - 'a']++;
            exist[str2[i] - 'a']--;
        }
        for(int i : exist) {
            if (i > 0)
                return false;
        }
        return true;
    }

}
