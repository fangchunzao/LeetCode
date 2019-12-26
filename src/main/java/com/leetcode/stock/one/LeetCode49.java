package com.leetcode.stock.one;


import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @description
 * @date 2019-12-26 16:41
 **/
public class LeetCode49 {

    public static void main(String[] args) {
        LeetCode49 obj = new LeetCode49();
        obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    // hash表 将排序后相同的str放到一起
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList();

        Map<String, List<String>> ans = new HashMap<>();

        for(String str : strs) {
            // 对str进行排序
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            // key
            String key = String.valueOf(ch);
            // 判断key是否存在 不存在新建 存在新增
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList<>());
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

}
