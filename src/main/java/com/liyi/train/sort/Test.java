package com.liyi.train.sort;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-12 19:10
 */
public class Test {
    public static void main (String[] args) {
        int[] data = {23, 1, 0, 43, 12, 134, 77, 43, 14, 25, 0, 98, 234, 7, 32, 90, 14, 23, 65, 46, 37, 28, 82};
        int[] result = BasicSort.sort(data);
        for (int item :
                result) {
            System.out.print(item + " ");
        }
    }
}
