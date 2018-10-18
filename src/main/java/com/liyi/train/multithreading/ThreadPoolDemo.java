package com.liyi.train.multithreading;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @description:线程池
 * @author: liyi
 * @create: 2018-10-16 18:01
 */
public class ThreadPoolDemo {
    public static void main (String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread (Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("Thread-" + new Random().nextInt(100));
                        return thread;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            int index = i;
            threadPoolExecutor.execute(() -> System.out.println( index + ": " + Thread.currentThread().getName()));
        }
        threadPoolExecutor.shutdown();
    }

}
