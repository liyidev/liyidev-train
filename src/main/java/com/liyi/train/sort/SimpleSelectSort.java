package com.liyi.train.sort;

/**
 * @description:简单选择排序
 * @author: liyi
 * @create: 2018-10-12 19:17
 */
public class SimpleSelectSort {
    public static int[] sort (int[] data) {
        int min;
        for (int i = 0; i < data.length; i++) {
            min = data[i];
            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    data[i] = data[j];
                    data[j] = min;
                    min = data[i];
                }
            }
        }
        return data;
    }
}
