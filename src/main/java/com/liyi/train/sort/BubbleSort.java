package com.liyi.train.sort;

/**
 * @description:冒泡排序
 * @author: liyi
 * @create: 2018-10-12 19:06
 */
public class BubbleSort {
    public static int[] sort (int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }
}
