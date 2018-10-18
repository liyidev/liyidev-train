package com.liyi.train.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:循环屏障CyclicBarrier例子
 * @author: liyi
 * @create: 2018-10-16 17:08
 */
public class SummonDragonDemo {
    private static final int THREAD_COUNT_NUM = 7;

    public static void main (String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT_NUM,
                new Runnable() {
                    @Override
                    public void run () {
                        System.out.println("执行");
                    }
                });

        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("召集第" + index + "个法师");
                    System.out.println(index + ":" + cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
