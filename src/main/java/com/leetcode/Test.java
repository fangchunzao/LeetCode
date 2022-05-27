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


    //  300. 最长递增子序列
    //
    // 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //
    //子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    //
    // 
    //示例 1：
    //
    //输入：nums = [10,9,2,5,3,7,101,18]
    //输出：4
    //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    //示例 2：
    //
    //输入：nums = [0,1,0,3,2,3]
    //输出：4
    //示例 3：
    //
    //输入：nums = [7,7,7,7,7,7,7]
    //输出：1
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/longest-increasing-subsequence
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    //    作者：jyd
    //    链接：https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    // 输入：nums = [10,9,2,5,3,7,101,18]
    // 输出：4
    // 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

    // 输入：nums = [0,1,0,3,2,3]
    // 输出：4

    // 输入：nums = [0,2,3,9,10,3,5,6,7]
    // 输入：nums = [1,2,3,4, 5,3,4,5,6]
    // 输出：4
    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // [0,2,0,3,4,5]
    // [0,2]
    // [0]
    public int lengthOfLIS33(int[] nums) {

        int[] res = new int[nums.length];
        res[0] = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res[index]) {
                res[++index] = nums[i];
                continue;
            }
            int temp = index;
            while (temp >= 0 && res[temp] >= nums[i]){
                temp--;
            }
            res[++temp] = nums[i];
        }
        return index + 1;
    }


    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

}

