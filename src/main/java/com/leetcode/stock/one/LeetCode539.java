package com.leetcode.stock.one;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 *
 *
 * 示例 1：
 *
 * 输入: ["23:59","00:00"]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode539 {

    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()];
        int num = 0;
        for(String s: timePoints){
            time[num]=60*((s.charAt(0)-'0')*10+s.charAt(1)-'0')+(s.charAt(3)-'0')*10+s.charAt(4)-'0';
            num++;
        }
        Arrays.sort(time);
        int min = 24 * 60 - time[time.length - 1] + time[0];
        for(int i = 0; i < time.length-1; i++){
            int timeD = time[i+1] - time[i];
            if(timeD < min)
                min = timeD;
        }
        return min;

    }

}
