package com.leetcode;

import java.util.*;

/**
 * @author FCZ 
 * @since 2018/12/14 10:18
 */
public class Test {

    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i]);
            if (prices[i] < minprice) {
                System.out.println("-----");
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        System.out.println(maxprofit);
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        maxProfit(prices);
    }


    public boolean judgeCircle(String moves) {
        int hang = 0; // 计算行
        int lie = 0;  // 计算列
        for (int i = 0; i < moves.length(); i++) {
            char symbol = moves.charAt(i);
            switch (symbol) {
                case 'R' : hang++; break; // 右
                case 'L' : hang--; break; // 左
                case 'U' : lie++; break; // 上
                case 'D' : lie--; break; // 下
            }
        }
        return hang == 0 && lie == 0;
    }

    public boolean dasds(String moves) {
        int[] count = new int[26];
        for (char c : moves.toCharArray())
            count[c - 'A']++;
        return (count['U' - 'A'] == count['D' - 'A'] && count['L' - 'A'] == count['R' - 'A']);
    }

    public int maxSubArray1(int[] nums) {
        if(nums.length==0)
            return 0;
        int addNum = nums[0];
        int maxNum = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {

            if (addNum < nums[i]) {
                addNum = nums[i];
                continue;
            }

            addNum += nums[i];

            maxNum = Math.max(addNum, maxNum);
        }
        return maxNum;
    }

    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
        int cursum=nums[0];
        int maxsum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            cursum=Math.max(nums[i],cursum+nums[i]);
            maxsum=Math.max(cursum,maxsum);
        }
        return maxsum;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(n, list, "",0, 0);
        return list;
    }

    public void generateParenthesis(int n, List<String> list, String str, int left, int right) {
        if (left == n && right == n) {
            list.add(str);
            return;
        }

        if (left < n)
            generateParenthesis(n, list, str + "(", left + 1, right);

        if (right < left)
            generateParenthesis(n, list, str + ")", left, right + 1);

    }

}
