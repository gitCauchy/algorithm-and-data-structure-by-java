package com.cauchy.sort;

import java.util.Arrays;

/**
 * 
 * @author Cauchy
 * @ClassName BubbleSort.java
 * @Date 2019��12��3��
 * @Description ð�������㷨ʵ��
 * @Version 0.1
 *
 */
public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		int tmp;
		// ����Ҫ�Ƚ�length - 1  ��
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
