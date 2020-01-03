package com.leetcode.stock.one;

import java.util.Arrays;

/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @description
 * @date 2020-01-03 15:26
 **/
public class LeetCode55 {

    public static void main(String[] args) {
        LeetCode55 obj = new LeetCode55();
        System.out.println(obj.canJump3(new int[] {3,2,1,0,4}));
    }

    // 自顶向下的动态规划
    // 对于数组中的每个位置，我们记录当前坐标是好 / 坏，记录在数组 memo 中，
    // 定义元素取值为 GOOD ，BAD，UNKNOWN。这种方法被称为记忆化。

    // 例如，对于输入数组 nums = [2, 4, 2, 1, 0, 2, 0] 的记忆表如下，
    // G 代表 GOOD，B 代表 BAD。我们发现不能从下标 2，3，4 到达最终坐标 6，但可以从 0，1，5 和 6 到达最终坐标 6。
    // Index 0 	1	2	3	4	5	6
    // nums	 2	4	2	1	0	2	0
    // memo	 G	G	B	B	B	G	G
    //
    enum Index {
        GOOD, BAD, UNKNOWN
    }
    Index[] memo;

    public boolean canJump(int[] nums) {
        // 1. 初始化 memo 的所有元素为 UNKNOWN，除了最后一个显然是 GOOD （自己一定可以跳到自己）
        memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    public boolean canJumpFromPosition(int position, int[] nums) {
        // 2. 优化递归算法，每步回溯前先检查这个位置是否计算过（当前值为：GOOD / BAD）
        //    1. 如果已知直接返回结果 True / False
        //    2. 否则按照之前的回溯步骤计算
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }
        // 计算最长能够跨越多少位数字
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                // 3. 计算完毕后，将结果存入memo表中
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    // 自底向上的动态规划
    // 底向上和自顶向下动态规划的区别就是消除了回溯，在实际使用中，自底向下的方法有更好的时间效率因为我们不再需要栈空间，
    // 可以节省很多缓存开销。更重要的事，这可以让之后更有优化的空间。回溯通常是通过反转动态规划的步骤来实现的。
    //
    // 这是由于我们每次只会向右跳动，意味着如果我们从右边开始动态规划，每次查询右边节点的信息，都是已经计算过了的，
    // 不再需要额外的递归开销，因为我们每次在 memo 表中都可以找到结果。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean canJump2(int[] nums) {
        Index[] memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        memo[memo.length - 1] = Index.GOOD;
        // 从后往前
        for (int i = nums.length - 2; i >= 0; i--) {
            // 计算当前位置 i 能够跨越多少位数字
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            // i + 1 到 furthestJump 区间内 为能够跨越的距离范围
            // 如果区间内存在GOOD位置 以为 i 到 该GOOD是 可到达的
            // 表示当前位置 i 也是GOOD
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    // 贪心算法
    //
    // 从右向左迭代，对于每个节点我们检查是否存在一步跳跃可以到达 GOOD 的位置
    // 如果可以到达，当前位置也标记为 GOOD
    // 同时，这个位置将成为新的最左边的 GOOD 位置
    // 一直重复到数组的开头
    // 如果第一个坐标标记为 GOOD 意味着可以从第一个位置跳到最后的位置。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean canJump3(int[] nums) {
        int lastPos = nums.length - 1;
        // 从后往前遍历
        // i + nums[i] 表示能够最大跨越距离
        // 如果 当前需要跨越的距离 小于 最大跨域的距离 就意味 能够到达目标位置
        // 找不到即无法到达
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }




    // 回溯 超时
    public boolean canJump1(int[] nums) {
        if (nums.length == 0) return true;
        return canJump(nums, nums.length - 1);
    }

    public boolean canJump(int[] nums, int index) {
        if (index == 0) return true;

        for (int i = index - 1, value = 1; i >= 0; i--, value++) {
            if (nums[i] >= value) {
                if (canJump(nums, i))
                    return true;
            }
        }
        return false;
    }

}
