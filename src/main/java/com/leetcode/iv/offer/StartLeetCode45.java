package com.leetcode.iv.offer;

/**
 * @author fcz
 * description 面试题45. 把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020-04-20 16:53
 **/
public class StartLeetCode45 {

    //  设 nums 任意两数字的字符串格式 x 和 y
    //  使用快排 按照 x + y > y + x 的规则进行排序
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    void fastSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        fastSort(strs, l, i - 1);
        fastSort(strs, i + 1, r);
    }

    public void quickSort(String[] strNum, int left, int right) {
        if (left >= right)
            return;
        String firstStr = strNum[left];
        int l = left, r = right;
        while (l < r) {
            while ((strNum[r] + firstStr).compareTo((firstStr + strNum[r])) >= 0 && l < r) {
                r--;
            }
            while ((strNum[l] + firstStr).compareTo(firstStr + strNum[l]) <= 0 && l < r) {
                l++;
            }
            if (l < r)
                swap(strNum, l, r);
        }
        swap(strNum, left, r);
        quickSort(strNum, left, r - 1);
        quickSort(strNum, r + 1, right);
    }

    public void swap(String[] strNum, int i, int j) {
        String temp = strNum[i];
        strNum[i] = strNum[j];
        strNum[j] = temp;
    }

}
