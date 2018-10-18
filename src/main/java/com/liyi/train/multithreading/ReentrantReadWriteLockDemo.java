package com.liyi.train.multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:ReetrantReadWriteLock读写锁demo
 * @author: liyi
 * @create: 2018-10-16 15:54
 */
public class ReentrantReadWriteLockDemo {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private void read () {
        try {
            try {
                readWriteLock.readLock().lock();
                System.out.println("获得读锁 " + Thread.currentThread().getName() + " 时间："
                        + System.currentTimeMillis());
                Thread.sleep(5000);
            } finally {
                readWriteLock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        new Thread(() -> demo.read(), "ThreadA").start();
        new Thread(() -> demo.read(), "ThreadB").start();
    }

}
