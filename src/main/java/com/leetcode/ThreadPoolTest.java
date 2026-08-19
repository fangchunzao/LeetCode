package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadPoolTest {

    AtomicInteger abc;
    AtomicReference atomicReference;


    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,10L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(50));
        executor.allowCoreThreadTimeOut(true);

        try {
            for (int i = 0; i < 5; i++) {
               executorService.execute(new CustomThread());
            }
        } catch (Exception e) {
            System.out.println("main thread exception");
            e.printStackTrace();
        }

        System.out.println("over");
        Thread.sleep(10 * 1000);
        executorService.execute(new Custom3Thread());
        executorService.execute(new Custom3Thread());

    }


}

class CustomThread implements Runnable {

    @Override
    public void run() {
//        for (int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "is start.");
//        }
    }
}

class Custom3Thread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "is start." + i);
        }
    }
}

class Custom2Thread implements Callable {

    @Override
    public String call() throws Exception {

        //        System.out.println("thread start");
//        throw new RuntimeException("abc");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "is start." + i);
        }
        return "01";
    }
}

