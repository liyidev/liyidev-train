package com.liyi.train.multithreading;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @description:ThreadLocal例子
 * @author: liyi
 * @create: 2018-10-16 21:52
 */
public class ThreadLocalDemo {
    public static void main (String[] args) {
        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        ThreadLocal<String> threadLocal3 = new ThreadLocal<>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        executor.execute(() -> {
            threadLocal1.set("123");
            threadLocal2.set("234");
            threadLocal3.set("345");
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName());
        });
    }
}
