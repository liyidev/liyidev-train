package com.liyi.train.multithreading.future;

import java.util.concurrent.*;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-16 20:30
 */
public class FutureMain {
    public static void main (String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new RealData("Hello"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.execute(futureTask);

        System.out.println("请求完毕！");
        try {
            Thread.sleep(2000);
            System.out.println("这里经过了一个2秒的操作！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("真实数据：" + futureTask.get());
        threadPoolExecutor.shutdown();
    }
}
