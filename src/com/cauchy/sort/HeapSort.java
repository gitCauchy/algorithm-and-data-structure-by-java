package com.cauchy.sort;

import java.util.Arrays;

/**
 *
 * @author Cauchy
 * @ClassName HeapSort.java
 * @Date 2019年12月9日
 * @Description 堆排序
 * @Version V0.1
 *
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {9,6,8,7,0,1,10,4,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void maxHeap(int [] arr,int size,int index) {
        // 找到两个子节点
        int lNode = 2*index + 1;
        int rNode = 2*index + 2;
        int max = index;
        // 和两个子节点进行对比，找到最大的节点
        if(lNode < size&&arr[lNode] > arr[max]) {
            max = lNode;
        }
        if(rNode < size&&arr[rNode] > arr[max]) {
            max = rNode;
        }
        // 调整交换位置
        if(max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            // 交换位置后可能会破坏之前排好的堆，需要重新调整
            maxHeap(arr,size,max);
        }
    }

    public static void heapSort(int arr[]) {
        int start = (arr.length - 1) / 2;
        for(int i = start; i >= 0; i --) {
            maxHeap(arr,arr.length,i);
        }
        // 将最大值移动到最后一个叶子节点,再把前面的处理成大顶堆
        for(int i = arr.length -1 ; i > 0; i --) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr,i,0);
        }
    }
}
