package com.leetcode.stock.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/8/20 14:40
 **/
public class LeetCode131 {

    public static void main(String[] args) {
        LeetCode131 obj = new LeetCode131();
        obj.partition("aabbcc");
    }

    List<List<String>>list=new ArrayList<>();

    public List<List<String>> partition(String s) {
        partition(s, 0, new ArrayList<>());
        return list;
    }

    public void partition(String s, int index, List<String> ls) {
        if (index == s.length()) {
            list.add(new ArrayList<>(ls));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                // 如果是回文串 添加入ls中 并且进行递归
                ls.add(s.substring(index, i + 1));
                partition(s, i + 1, ls);
                // 删除队尾元素
                ls.remove(ls.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }



/*
    List<List<String>>list=new ArrayList<>();
    String s;

    public List<List<String>> partition1(String s) {
        //从头到尾递归 + 回溯。
        this.s=s;
        //这个是满足的每一个集合
        List<String> ll = new ArrayList<>();
        dfs(ll,0);
        return list;
    }

    public void dfs(List<String>ll, int index) {
        if (index == s.length()) {
            list.add(new ArrayList<>(ll));
            return;
        }
        //i从index开始是因为单个字符也是回文子串
        for (int i = index; i < s.length(); i++) {
            //如果是回文
            if (isPalindrome(index, i)) {

                //把当前的回文子串s(index,i)加进去
                ll.add(s.substring(index, i + 1));
                dfs(ll, i + 1);
                //把加进去的回文子串去处。和上面加进去的回文子串是同一个回文子串。
                ll.remove(ll.size() - 1);
            }

        }
    }

    public boolean isPalindrome(int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
*/

}
