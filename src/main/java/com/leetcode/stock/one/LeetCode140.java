package com.leetcode.stock.one;

import java.util.*;

/**
 *
 * 140. 单词拆分 II
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/21 09:30
 **/
public class LeetCode140 {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        LeetCode140 obj = new LeetCode140();
//        obj.wordBreak1(s, new HashSet<>(wordDict));
        obj.wordBreak(s, wordDict);
    }

    List<String> result = new ArrayList<>();
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordBreak(s, new HashSet<>(wordDict), 0, new ArrayList<>());
        return result;
    }

    public void wordBreak(String s, Set<String> wordDict, int index, List<String> wordString) {
        if (s.length() == index) {
            result.add(String.join(" ", wordString));
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (wordDict.contains(word)) {
                wordString.add(word);
                wordBreak(s, wordDict, i, wordString);
                wordString.remove(wordString.size() - 1);
            }
        }
    }


    public List<String> wordBreak1(String s, Set<String> wordDict) {
        List<String> list = word_Break1(s, wordDict, 0);
        return list;
    }

    public List<String> word_Break1(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break1(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }


}
