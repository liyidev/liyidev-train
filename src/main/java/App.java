import com.liyi.train.Father;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-10 19:30
 */
public class App {
    private static AtomicStampedReference<Integer> money =
            new AtomicStampedReference<Integer>(19, 0);
    public static void main (String[] args) {

        for (int i = 0; i < 10; i++) {
            final int stamp = money.getStamp();

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
            //test5
            //test4
            //test3
            //testMerge
            System.out.println(new Random().nextInt(10));
            //        System.out.println(result);
        }
    }

    @Test
    public void contact () {
        String s1 = "a";
        String s2 = "a";
        String s3 = "a" + "a";
        String s5 = "aa";
        System.out.println(s3 == s5);
    }

    public class ASS {

    }
}
