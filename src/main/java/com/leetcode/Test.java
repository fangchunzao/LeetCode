package com.leetcode;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author FCZ 
 * @since 2018/12/14 10:18
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.findKth(new int[]{1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663},
                49, 24);
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        findKthQuickSort(a, 0, n-1, K);
        for (int i = 0; i < K; i++) {
            System.out.println(i);
            if (a[i] > 986578)
                System.out.println(a[i]);
        }

        return a[K];
    }

    public void findKthQuickSort(int[] a, int left, int right, int k) {
        if(left > right)
            return;
        int res = quickSort(a, left, right);
        if(res + 1 == k) {
            return;
        } else if (res + 1 < k) {
            findKthQuickSort(a, res + 1, right, k);
        } else {
            findKthQuickSort(a, left, res - 1, k);
        }
    }

    public int quickSort(int[] a, int left, int right) {
        int flag = a[right];
        int j = left;
        for(int i = left; i < right; i++) {
            if(a[i] < flag) {
                swap(a,i,j);
                j++;
            }
        }
        swap(a, j, right);
        return j;
    }

    private void swap(int[] a ,int i ,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }



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

