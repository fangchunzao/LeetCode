package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * 1103. 分糖果 II
 *
 * 排排坐，分糖果。
 *
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 *
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 *
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 *
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 *
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 * 示例 2：
 *
 * 输入：candies = 10, num_people = 3
 * 输出：[5,2,3]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3]。
 * 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies-to-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCode1103 {

    public static void main(String[] args) {
        LeetCode1103 obj = new LeetCode1103();
        System.out.println(Arrays.toString(obj.distributeCandies(0, 2)));

    }

    // 暴力法
    public int[] distributeCandies1(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }

    /**
     * 例如 ：candies = n, num_people = 3 可拆解为
     *  1       2      3      第0层  总数：6   计算公式: (0 * num_people) * num_people + 第0层的总数
     * 3+1     3+2    3+3     第1层  总数：15  计算公式: (1 * num_people) * num_people + 第0层的总数
     * 3+3+1  3+3+2  3+3+3    第2层  总数：24  计算公式: (2 * num_people) * num_people + 第0层的总数
     * 每个索引位置的值 公式为: level * num_people + i + 1 (i为数组下标索引，因为数组从0开始)
     *
     * 因此 首先要计算出第0层的总数，即可往下层递推
     *
     * candies总数固定为n  从第0层持续往第L层递推减法运算
     * 当 candies <= 0 既为最后一层 得出总层数 L
     *
     * 通过索引位置计算公式， 可以纵向计算计算每一层的值 累加就是该位置的最终值
     *
     * 注意 当candies == 0 时 是刚好能把最后一层放满
     * 但是往往 candies 是 小于 0 的
     *
     * 因此 对于 candies < 0 的情况
     *   首先计算出最后一层的总个数（lastLevelSum），candies此时的值是 放满这一层 还差多少
     *   那么这一层所需要的值就是 lastLevelSum + candies
     *
     *   这就是最后一层的值 (lastLevelCount)
     *   最后一层的值确定了 就可以在 i 位置 按照层 从L层到0层的递加计算
     *
     */
    public int[] distributeCandies(int candies, int num_people) {
        // 求出第一层需要多少个糖果
        int peopleTemp = num_people;
        int levelFirstCount = 0;
        while (peopleTemp > 0) {
            levelFirstCount += peopleTemp--;
        }
        // 计算出有多少层
        int level = 0;
        int candiesTemp = candies - levelFirstCount;
        while (candiesTemp > 0) {
            level++;
            candiesTemp -=  (level * num_people) * num_people + levelFirstCount;
        }
        // 找到倒霉孩子
        int[] result = new int[num_people];
        if (candiesTemp < 0) {
            int lastLevelSum = (level * num_people) * num_people + levelFirstCount;
            int lastLevelNum = lastLevelSum + candiesTemp;

            for (int i = 0; i < num_people; i++) {
                // 按照层数计算， 从下往上
                int indexNum = 0;
                if (lastLevelNum > 0) {
                    int needNum = level * num_people + i + 1;
                    if (lastLevelNum > needNum) {
                        indexNum = needNum;
                        lastLevelNum -= needNum;
                    } else {
                        indexNum = lastLevelNum;
                        lastLevelNum = 0;
                    }
                }
                for (int j = level - 1; j >= 0; j--) {
                   indexNum += j * num_people + i + 1;
                }
                result[i] = indexNum;
            }
        } else {
            for (int i = 0; i < num_people; i++) {
                // 按照层数计算， 从下往上
                int indexNum = 0;
                for (int j = level; j >= 0; j--) {
                    indexNum += j * num_people + i + 1;
                }
                result[i] = indexNum;
            }
        }
        return result;
    }

}
