package com.liyi.train.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:基数排序
 * @author: liyi
 * @create: 2018-10-13 19:56
 */
public class BasicSort {
    public static int[] sort (int[] data) {
        int max = data[0];
        for (int item : data) {
            if (item > max) {
                max = item;
            }
        }
        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList item = new ArrayList();
            queue.add(item);
        }
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < data.length; j++) {
                int x = data[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList a = queue.get(x);
                a.add(data[j]);
            }
            //开始收集
            int count = 0;
            for (int j = 0; j < 10; j++) {
                while (!queue.get(j).isEmpty()) {
                    ArrayList<Integer> a = queue.get(j);
                    data[count++] = a.get(0);
                    a.remove(0);
                }
            }
        }
        return data;
    }
}
