package com.liyi.train.sort;

/**
 * @description:堆排序
 * @author: liyi
 * @create: 2018-10-13 14:20
 */
public class HeepSort {
    public static int[] sort (int[] data) {
        //构建最大堆
        buildMaxHeap(data);
        for (int i = data.length - 1; i >= 1; i--) {
            //最大的在0位置，那么开始沉降，这样每交换一次最大的值就丢到最后了
            exchangeElement(data, 0, i);
            //继续获取0位置最大值
            maxHeap(data, i, 0);
        }
        return data;
    }

    private static void buildMaxHeap (int[] data) {
        // 非叶子节点下标
        int half = data.length / 2 - 1;
        for (int i = half; i >= 0; i--) {
            maxHeap(data, data.length, i);
        }
    }

    private static void maxHeap (int[] data, int length, int i) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int largest = i;
        if (leftChild < length && data[leftChild] > data[i]) {
            largest = leftChild;
        }
        if (rightChild < length && data[rightChild] > data[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            exchangeElement(data, i, largest);
            maxHeap(data, length, largest);
        }
    }

    private static void exchangeElement (int[] data, int i, int largest) {
        int temp = data[i];
        data[i] = data[largest];
        data[largest] = temp;
    }
}
