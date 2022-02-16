package com.cauchy.sort;

import java.util.Arrays;
/**
 *
 * @author Cauchy
 * @ClassName ShellSort.java
 * @Date 2019年12月3日
 * @Description 希尔排序
 * @Version
 *
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 7, 6, 0, 9, 1, 7, 4, 2 };
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        // 遍历所有的步长
        for (int d = arr.length / 2; d > 0; d /= 2) {
            for (int i = d; i < arr.length; i++) {
                for (int j = i - d; j >= 0; j -= d) {
                    if (arr[j] > arr[j + d]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = tmp;
                    }
                }
            }
        }
    }
}
