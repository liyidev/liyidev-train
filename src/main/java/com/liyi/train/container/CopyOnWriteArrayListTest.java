package com.liyi.train.container;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:测试CopyOnWriteArrayList的并发操作
 *
 * 结果：
     * ThreadOne 遍历:10
     * ThreadTwo 遍历：10
     * ThreadTwo 遍历：30
     * ThreadOne 遍历:20
     * ThreadOne 遍历:30
 *
 * 所以证明了CopyOnWriteArrayList的COWIterator遍历的是自己的常量snapshot；
 * 任何对array在结构上有所改变的操作（add、remove、clear等），CopyOnWriterArrayList都会copy现有的数据，
 * 再在copy的数据上修改，这样就不会影响COWIterator中的数据了，修改完成之后再改变原有数据的引用
 *
 * @author: liyi
 * @create: 2018-10-14 22:00
 */
public class CopyOnWriteArrayListTest {
    private static List<Integer> list = new CopyOnWriteArrayList<Integer>();
    public static void main (String[] args) {
        list.add(10);
        list.add(20);
        list.add(30);
        new ThreadOne().start();
        new ThreadTwo().start();
    }
    private static class ThreadOne extends Thread {

        @Override
        public void run () {
            Iterator iterator = list.iterator();
            while(iterator.hasNext()) {
                int i = (Integer)iterator.next();
                System.out.println("ThreadOne 遍历:" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreadTwo extends Thread {

        @Override
        public void run () {
            list.remove(1);
            for (int i :
                    list) {
                System.out.println("ThreadTwo 遍历：" + i);
            }
        }
    }
}
