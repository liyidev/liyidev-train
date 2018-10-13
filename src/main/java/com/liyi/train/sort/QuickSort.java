package com.liyi.train.sort;

/**
 * @description:快速排序(不稳定)
 * @author: liyi
 * @create: 2018-10-12 19:50
 */
public class QuickSort {
    public static int[] sort (int[] data) {
        quickSort(0, data.length - 1, data);
        return data;
    }

    private static void quickSort (int left, int right, int[] data) {
        if (left >= right) {
            return;
        }
        int key = data[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && data[j] > key) {
                j--;
            }
            while (i < j && data[i] <= key) {
                i++;
            }

            if (i < j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        data[left] = data[i];
        data[i] = key;
        quickSort(left, i - 1, data);
        quickSort(i + 1, right, data);
    }
}
