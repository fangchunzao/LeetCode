package com.leetcode.iv.dic;

import java.util.Map;
import java.util.TreeMap;

/**
 * description 面试题 10.10. 数字流的秩
 *
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
 *
 * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
 *
 * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例:
 *
 * 输入:
 * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
 * [[], [1], [0], [0]]
 * 输出:
 * [null,0,null,1]
 * 提示：
 *
 * x <= 50000
 * track 和 getRankOfNumber 方法的调用次数均不超过 2000 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-from-stream-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-08-01 20:17:33
 */
public class Dic10_10 {

    // TreeMap底层是红黑树实现的，也叫自平衡搜索二叉树，这个是通解
    TreeMap<Integer, Integer> map;

    public Dic10_10() {
        map = new TreeMap<>();
    }

    public void track(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    public int getRankOfNumber(int x) {
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() > x) {
                return count;
            }
            count += entry.getValue();
        }
        return count;
    }


    // hash，缺点是如果测试用例里有小于0的，则无法使用
    class StreamRank1 {
        int[] count;
        public StreamRank1() {
            count = new int[50001];
        }

        public void track(int x) {
            count[x]++;
        }

        public int getRankOfNumber(int x) {
            int res = 0;
            for(int i = 0;i <= x;i++) {
                res += count[i];
            }
            return res;
        }
    }
}

// 树状数组的缺点是，0位置不能利用，小于0的数也无法处理，但查询效率是最高的
class StreamRank2 {

    int[] tree;
    public StreamRank2() {
        tree = new int[50001];
    }

    public void track(int x) {
        if(x == 0) {              // 与树状数组不同的是，0位置要单独处理
            tree[0]++;            // 因为树状数组索引是从 1 开始的
            return;
        }
        while(x < tree.length) {
            tree[x]++;
            x += lowbit(x);
        }
    }

    public int getRankOfNumber(int x) {
        int res = 0;
        while(x > 0) {
            res += tree[x];
            x -= lowbit(x);
        }
        return res + tree[0];      // 处理0位置的计数
    }

    public int lowbit(int x) {
        return x & (-x);
    }
}