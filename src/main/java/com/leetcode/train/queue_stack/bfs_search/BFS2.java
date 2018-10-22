package com.leetcode.train.queue_stack.bfs_search;

import java.util.*;

/**
 * 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * @author FCZ
 * @since 2018/10/22 09:44
 */
public class BFS2 {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        int count = openLock(deadends, target);
        System.out.println(count);
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    /**
     * description: 四位密码每次都增加1，判断与target
     * @param deadends:
     * @param target:
     * @author FCZ
     * @since 2018-10-22
     */
    public static int openLock(String[] deadends, String target) {
        final String start = "0000";
        Set<String> visited = new HashSet<String>(){{add(start);}}; // 走过的路径
        Queue<String> queue = new LinkedList<String>(){{add(start);}}; // 待处理
        // 将deadends数组 转为Set
        Set<String> deadEndSet = new HashSet<>(Arrays.asList(deadends));
        if (deadEndSet.contains(start)) return -1; // 死亡数组中存在"0000"
        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String top = queue.peek(); queue.poll();
                // 查找下一层全部元素 （每个密码 + 1）
                List<String> nextFloor = findNextNode(top);
                for (String str : nextFloor) {
                    // 是否与target相等
                    if (target.equals(str)) {
                        count++;
                        return count;
                    }
                    // 是否已经存在
                    if (findString(visited, str)) {
                        continue;
                    }
                    // 是否为死亡数组
                    if (!findString(deadEndSet, str)) { // 不是，将当前值放入 待处理数组中
                        visited.add(str);
                        queue.offer(str);
                    }
                }
            }
            count++;


        }
        return -1;
    }

    private static List<String> findNextNode(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int c = Integer.valueOf(String.valueOf(s.charAt(i)));
            String node1 = String.valueOf((c + 1) % 10);
            result.add(s.substring(0,i) + node1 + s.substring(i + 1));
            String node2 = String.valueOf((c + 9) % 10);
            result.add(s.substring(0,i) + node2 + s.substring(i + 1));
        }
        return result;
    }

    public static List<String> findNeibors(String s) {
        String temp = s;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            char[] charTemp = temp.toCharArray();
            charTemp[i] = String.valueOf((Integer.parseInt(String.valueOf(charTemp[i])) + 1) % 10).toCharArray()[0];
//            charTemp[i] = (char) ((Integer.parseInt(String.valueOf(charTemp[i])) + 1) % 10);
            result.add(String.valueOf(charTemp));
            charTemp[i] = String.valueOf((Integer.parseInt(String.valueOf(charTemp[i])) + 8) % 10).toCharArray()[0];
            result.add(String.valueOf(charTemp));
        }
        return result;
    }

    public static boolean findString(Set<String> tofind, String s) {
        if (tofind.contains(s)) return true;
        return false;
    }
}
