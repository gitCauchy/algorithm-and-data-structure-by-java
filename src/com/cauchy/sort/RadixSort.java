package com.cauchy.sort;
/**
 *
 * @author Cauchy
 * @ClassName RadixSort.java
 * @Date 2019年12月3日
 * @Description 基数排序
 * @Version
 *
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {45,2,897,102,7,508,367,42,76,34};
        radixSort(arr);
        System.out.println(arr);
    }

    public static void radixSort(int[] arr) {
        int temp[][] = new int [10][arr.length];
        for(int i = 0,n=1; i < getFigures(arr); i ++,n*=10) {
            int [] counts = new int[10];
            for(int j = 0 ; j < arr.length; j ++) {
                // 计算余数
                int rmd = arr[j]/n % 10;
                temp[rmd][counts[rmd]] = arr[j];
                counts[rmd] ++;

            }
            int index = 0;
            for(int k = 0; k < counts.length; i ++) {
                if(counts[k] !=0 ) {
                    // 循环取出元素
                    for(int l = 0; l < counts[k]; l ++) {
                        arr[index ++] = temp[k][l];
                    }
                    // 将数量置空
                    counts[k] = 0;
                }
            }
        }

    }

    public static int getFigures(int[] arr) {

        int max = arr[0];
        int figure = 1;
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
//		while(max / 10 != 0) {
//			figure ++;
//			max /= 10;
//		}
        return Integer.toString(max).length();
    }
}




/**
 * 使用队列实现
 */
