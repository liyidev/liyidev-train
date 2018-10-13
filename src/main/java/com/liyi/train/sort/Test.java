package com.liyi.train.sort;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-12 19:10
 */
public class Test {
    public static void main (String[] args) {
        int[] data = {23, 1, 0, 43, 12, 134, 77};
        int[] result = BinaryInsertSort.sort(data);
        for (int item :
                result) {
            System.out.println(item);
        }
    }
}
