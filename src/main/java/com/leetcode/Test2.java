package com.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition wait = lock.newCondition();

    private static final Condition productWait = lock.newCondition();
    private static final Condition consumeWait = lock.newCondition();

    private Integer count = 5;


    public void tes23t()  {
        new Thread(() -> {
            try {
                if (lock.isLocked()) {
                    Thread.sleep(100);
                }
                lock.lock();
                // 业务代码

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });
    }


    // 线程标识 true.有锁 false.无锁
    private static boolean flag = false;

    public void test3()  {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    while (flag) {
                        wait.await();
                    }
                    flag = true;
                    // 业务代码

                    wait.signalAll();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    flag = false;
                    lock.unlock();
                }

            });
        }
    }

    // 生产者消费者
    public void test(){
        // 消费者
        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println("consume start. count:" + count + ". thread name:" + Thread.currentThread());
                    while (count <= 0) {
                        consumeWait.await();
                    }
                    Thread.sleep(1000);
                    count--;
                    productWait.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("consume end. count:" + count + ". thread name:" + Thread.currentThread());
                }

            }, "consume:" + i).start();
        }

        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println("product start. count:" + count + ". thread name:" + Thread.currentThread());
                    if (count >= 10) {
                        productWait.await();
                    }
                    count++;
                    consumeWait.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("product end. count:" + count + ". thread name:" + Thread.currentThread());
                }
            }, "product:" + i).start();
        }

    }

    public void test22() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                lock.lock();
                System.out.println(Thread.currentThread());
                lock.unlock();
            }).start();
        }
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        t.test();
    }

}

class TestR implements Runnable {

    private ReentrantLock lock;

    Condition wait;

    public TestR(ReentrantLock lock, Condition wait) {
        this.lock = lock;
        this.wait = wait;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": start");
        try {
            if (lock.isLocked()) {

            }
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ": get lock");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": release lock");


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
