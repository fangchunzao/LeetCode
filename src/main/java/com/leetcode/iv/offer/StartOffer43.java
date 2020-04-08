package com.leetcode.iv.offer;

/**
 * @author fcz
 * @description 面试题43. 1～n整数中1出现的次数
 *
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020-04-07 16:46
 **/
public class StartOffer43 {

    public static void main(String[] args) {
        System.out.println(1234);
        StartOffer43 obj = new StartOffer43();
        obj.countDigitOne(100);
    }

    /**
     * 举例501 511 521 说明问题：
     * ① 501在十位上：
     * 501十位 0 ，所以高位 5只能取0~4 ，此时十位才能取1，个位任意取0~9，共50种
     * ② 511在十位上：
     * 511 十位1，所以高位 5只能取0~4 ，此时十位才能取1，个位任意取0~9，共50种，另外当十位取1的时候，低位为1因此可以取到一个数字511，再加上原本的510，共52种。
     * ③ 521在十位上：
     * 521十位2，所以高位5可以取0~5，此时十位取1，个位任意取，共60种
     *
     * 作者：xyx1273930793
     * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/java100fu-si-lu-shuo-ming-by-xyx1273930793-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int countDigitOne(int n) {
        //求每个位的数字所用
        int index = 1;
        //记录1的个数
        int count = 0;
        int high = n,cur = 0,low = 0;
        //由于high = n /(index*10) 中index *10 很容易越位
        //特修改如下
        while(high > 0){
            // 从左往右对数字进行分割
            // 从右往左 去掉个位数
            high /= 10;
            // 获取个位数的值
            cur = (n / index) % 10;
            // 后面剩下的数字
            low = n - (n / index) * index;
            // 当前数字为0 能组成带1的组合 前面的数字可能是 1 --- high 后面的数字没有结果
            if(cur == 0) count += high * index;
            // 当前数字为1 能组成带1的组合 前面的数字可能  1 --- high 后面的数字 为 0 --- low
            if(cur == 1) count += high * index + low + 1;
            // 当前数字大于1 能组成带1的组合 前面的数字可能  0 --- high 后面的数字没有结果
            if(cur > 1) count += (high+1) * index;
            index *= 10;
        }
        return count;
    }
}
