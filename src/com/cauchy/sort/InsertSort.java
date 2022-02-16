package com.cauchy.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int [] arr = {2,1,5,4,7,6,0,9,1,7,4,2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int arr[]) {
        for(int i = 1; i < arr.length; i ++) {
            if(arr[i] < arr[i-1]) {
                int tmp = arr[i];
                int j;
                for( j = i - 1; j >= 0 && arr[j] > tmp; j --) {
                    arr[j+1] = arr[j];
                }
                arr[j+1] = tmp;
            }
        }
    }
}
