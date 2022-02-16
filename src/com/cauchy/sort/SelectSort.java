package com.cauchy.sort;

import java.util.Arrays;
/**
 *
 * @author Cauchy
 * @ClassName SelectSort.java
 * @Date 2019年12月3日
 * @Description 选择排序
 * @Version
 *
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 7, 6, 0, 9, 1, 7, 4, 2 };
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        // 遍历所有的元素
        for(int i = 0; i < arr.length; i ++) {
            int minIndex = i;
            // 当当前遍历的和后面所有的值进行比较,并记录最小的下标
            for(int j = i + 1; j < arr.length ; j ++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // 如果最小的数和当前遍历的值不相符
            if(i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
