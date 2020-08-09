package com.leetcode.iv.dic;

/**
 * description 面试题 16.15. 珠玑妙算
 *
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 *
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。
 * 打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
 * 注意，“猜中”不能算入“伪猜中”。
 *
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 *
 * 示例：
 *
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 * 提示：
 *
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/master-mind-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author FCZ
 * @since 2020-08-09 16:17:43
 */
public class Dic16_15 {

    public int[] masterMind(String solution, String guess) {
        char[] solChar = solution.toCharArray();
        char[] gueChar = guess.toCharArray();

        int solCount = 0, guessCount = 0;
        // 找出 “猜中” 并将“猜中”标识一下 不能继续计数了
        for (int i = 0; i < gueChar.length; i++) {
            if (solChar[i] == gueChar[i]) {
                solCount++;
                solChar[i] = ' ';
                gueChar[i] = ' ';
            }
        }
        // 遍历找出“伪猜中” 找出“伪猜中”需要标识一下 不能继续计数
        for (char c : gueChar) {
            if (c == ' ') continue;
            for (int j = 0; j < solChar.length; j++) {
                if (solChar[j] == ' ') continue;
                if (c == solChar[j]) {
                    solChar[j] = ' ';
                    guessCount++;
                    break;
                }
            }
        }
        return new int[]{solCount, guessCount};

    }

}
