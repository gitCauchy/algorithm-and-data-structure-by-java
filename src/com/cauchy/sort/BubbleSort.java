package com.cauchy.sort;

import java.util.Arrays;

/**
 * 
 * @author Cauchy
 * @ClassName BubbleSort.java
 * @Date 2019年12月3日
 * @Description 冒泡排序算法实现
 * @Version 0.1
 *
 */
public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		int tmp;
		// 共需要比较length - 1  轮
		for(int i = 0;i < arr.length - 1; i ++) {
			for(int j = 0; j < arr.length - i - 1; j ++) {
				if(arr[j] > arr[j+1]) {
					tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}
