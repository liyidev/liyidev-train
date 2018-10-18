package com.liyi.train.multithreading;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-16 10:09
 */
public class MultiThread {
    private int num = 200;

    public synchronized void printNum (String threadName, String tag) {
        if (tag.equals("a")) {
            num = num - 100;
            System.out.println(threadName + " tag a,set num over!");
        } else {
            num = num - 200;
            System.out.println(threadName + " tag b,set num over!");
        }
        System.out.println(threadName + " tag " + tag + ", num = " + num);
    }

    public static void main (String[] args) {
        final MultiThread multiThread = new MultiThread();
        new Thread(new Runnable() {
            @Override
            public void run () {
                multiThread.printNum("1", "a");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run () {
                multiThread.printNum("2", "b");
            }
        }).start();
    }
}
