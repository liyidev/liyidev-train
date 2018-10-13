package com.liyi.train.sort;

/**
 * @description:归并排序（不稳定）
 * @author: liyi
 * @create: 2018-10-13 19:33
 */
public class MergeSort {
    public static int[] sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
        return data;
    }
    private static void mergeSort(int [] data, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(data, left, middle);
            mergeSort(data, middle + 1, right);
            //合并
            merge(data,left,middle,right);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int [] tmpArray = new int[a.length];
        int rightStart = middle+1;
        int tmp = left;
        int third = left;
        //比较两个小数组相应下标位置的数组大小，小的先放进新数组
        while(left<=middle&&rightStart<=right){
            if(a[left]<=a[rightStart]){
                tmpArray[third++] = a [left++];
            }else{
                tmpArray[third++] = a[rightStart++];
            }
        }
        //如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
        while(left<=middle){
            tmpArray[third++] = a[left++];
        }
        //如果右边还有数据......
        while(rightStart<=right){
            tmpArray[third++] = a[rightStart++];
        }
        while(tmp<=right){
            a[tmp] = tmpArray[tmp++];
        }
    }
}
