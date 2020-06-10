package com.liyi.train.multithreading;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-17 17:50
 */
public class AtomicStampedReferenceDemo {
    private static AtomicStampedReference<Integer> money =
            new AtomicStampedReference<Integer>(19, 0);

    public static void main (String[] args) {
        for (int i = 0; i < 10; i++) {
            final int stamp = money.getStamp();

            new Thread(new Runnable() {
                public void run () {
                    while (true) {
                        Integer reference = money.getReference();
                        if (reference < 20) {
                            if (money.compareAndSet(reference, reference + 20,
                                    stamp, stamp + 1)) {
                                System.out.println("余额小于20，充值成功，余额为："
                                                + money.getReference() +
                                                "元！" + "stamp: " + stamp);
                                break;

                            } else {
                                break;
                            }
                        }
                    }
                }
            }, "rechargeThread" + i).start();
        }

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    while (true) {
                        Integer m = money.getReference();
                        int timeStamp = money.getStamp();
                        if (m > 10) {
                            System.out.println("大于10元，可以进行消费！");
                            if (money.compareAndSet(m, m - 10,
                                    timeStamp, timeStamp + 1)) {
                                System.out.println("消费成功，余额为：" + money.getReference()  + "stamp: " + timeStamp);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }, "userConsumeThread").start();
    }
}
