package com.liyi.train.sort;

/**
 * @description:插入排序
 * @author: liyi
 * @create: 2018-10-13 09:52
 */
public class InsertSort {
    public static int[] sort (int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (data[j] > temp) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = temp;
        }
        return data;
    }
}
