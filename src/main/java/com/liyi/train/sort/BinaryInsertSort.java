package com.liyi.train.sort;

/**
 * @description:二分插入排序
 * @author: liyi
 * @create: 2018-10-13 10:00
 */
public class BinaryInsertSort {
    public static int[] sort (int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (data[mid] > temp) {
                    right = mid - 1;
                }
                if (data[mid] < temp) {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                data[j + 1] = data[j];
            }
            if (left != i) {
                data[left] = temp;
            }
        }
        return data;
    }
}
