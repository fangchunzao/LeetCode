package com.leetcode.stock.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/20 15:28
 **/
public class LeetCode139 {

    public static void main(String[] args) {
        LeetCode139 obj = new LeetCode139();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");

//        System.out.println(obj.wordBreak("catsand",wordDict));
        System.out.println(obj.wordBreak3("catsand",wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
//        return wordBreak(s, 0, new HashSet<>(wordDict));
        return wordBreak2(s, 0, new HashSet(wordDict), new Boolean[s.length()]);
    }

    // 回溯+递归
    public boolean wordBreak(String s, int index, Set<String> wordDict) {
        if (index == s.length()) {
            return true;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index , i);
            if (wordDict.contains(word)) {
                if(wordBreak(s, i, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 记忆回溯
    public boolean wordBreak2(String s, int index, Set<String> wordDict, Boolean[] memo) {
        if (index == s.length()) {
           return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index , i);
            if (wordDict.contains(word)) {
                if(wordBreak2(s, i, wordDict, memo)) {
                    return memo[index] = true;
                }
            }
        }
        return memo[index] = false;
    }

    // 动态规划
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 使用i,j 将数组分为两部分  [0,j]  [j,i]
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
