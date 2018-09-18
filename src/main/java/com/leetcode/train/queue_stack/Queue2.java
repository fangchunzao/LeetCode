package com.leetcode.train.queue_stack;


class MyCircularQueue {

    private Integer[] data;

    private int head,tail;

    public MyCircularQueue(int length) {
        data = new Integer[length];
        head = -1;
        tail = -1;
    }
    /** Insert an element into the queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) { // 满了
            return false;
        }
        if (head == -1) head = 0;
        tail = (tail + 1) % data.length;
        data[tail] = value;
        return true;
    };
    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        data[head] = null;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % data.length;
        }
        return true;
    }
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }
    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % data.length == head;
    }
}

public class Queue2 {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(2); // 设置长度为3

        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.enQueue(9));
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(6));
        System.out.println(circularQueue.enQueue(4));

    }

}
