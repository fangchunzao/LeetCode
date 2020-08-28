package com.leetcode.iv.offer;

import java.util.ArrayList;
import java.util.List;

/**

 * description 面试题62. 圆圈中最后剩下的数字
 *
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，
 * 因此最后剩下的数字是3。
 * 0 1 3 4
 * 1 3 4
 * 1 3
 * 3
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fcz
 * @since  2020-03-30 17:31
 *
 * @since 2020-08-25 复习
 **/
public class Offer62 {

    public int lastRemaining1(int n, int m) {
        // 构造出一个list方便指定位置的remove
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            // 计算下一个删除的坐标位置
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    // 必须使用数学法 使用别的会超时
    // 时间复杂度O(n)
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }


}
