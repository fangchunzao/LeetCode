package com.leetcode.iv.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * description 面试题59 - II. 队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:[null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出:[null,-1,-1]
 *
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数<= 10000
 * 1 <= value <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fcz
 * @since 2020-06-10 16:17
 *
 * @since 2020-08-24 复习
 **/
public class StartOffer59_2 {

    Queue<Integer> que;
    Deque<Integer> deq;

    public StartOffer59_2() {
        que = new LinkedList<>();  //队列：插入和删除
        deq = new LinkedList<>();  //双端队列：获取最大值
    }

    public int max_value() {
        return deq.size() > 0 ? deq.peekFirst() : -1;
    }


    public void push_back(int value) {
        que.offer(value);
        while (!deq.isEmpty() && deq.peekLast() < value) {
            deq.removeLast();
        }
        deq.addLast(value);
    }

    public int pop_front() {
        Integer val = !que.isEmpty() ? que.poll() : -1;
        if (!deq.isEmpty() && deq.peekFirst().equals(val)) {
            deq.removeFirst();
        }
        return val;
    }



/*    Queue<Integer> que;
    Deque<Integer> deq;

    public Offer59_2() {
        que = new LinkedList<>();  //队列：插入和删除
        deq = new LinkedList<>();  //双端队列：获取最大值
    }

    public int max_value() {
        return deq.size() > 0 ? deq.peek() : -1;  //双端队列的队首为que的最大值
    }

    public void push_back(int value) {
        que.offer(value);  //value入队
        while(deq.size() > 0 && deq.peekLast() < value){
            deq.removeLast();  //将deq队尾小于value的元素删掉
        }
        deq.offerLast(value);  //将value放在deq队尾
    }

    public int pop_front() {
        int tmp = que.size() > 0 ? que.poll() : -1;  //获得队首元素
        if(deq.size() > 0 && deq.peek().equals(tmp)){
            deq.poll();  //如果出队的元素是当前最大值，将deq的队首出队
        }
        return tmp;
    }*/

}
