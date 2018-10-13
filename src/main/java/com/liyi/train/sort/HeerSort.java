package com.liyi.train.sort;

/**
 * @description:希尔排序（不稳定）
 * @author: liyi
 * @create: 2018-10-13 11:55
 */
public class HeerSort {
    public static int[] sort (int[] data) {
        // 增量increment
        int inc = data.length / 2;
        while (true) {
            if (inc < 1) {
                inc = 1;
            }
            for (int i = 0; i < inc; i++) {
                for (int j = i + inc; j < data.length; j += inc) {
                    int index = j;
                    for (int r = j - inc; r >= 0; r -= inc) {
                        if (data[r] > data[index]) {
                            int temp = data[r];
                            data[r] = data[index];
                            data[index] = temp;
                            index = r;
                        }
                    }
                }
            }
            if (inc == 1) {
                break;
            }
            inc-=4;
        }
        return data;
    }
}
