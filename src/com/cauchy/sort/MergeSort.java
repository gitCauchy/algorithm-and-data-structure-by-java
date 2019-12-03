package com.cauchy.sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int [] arr = {2,1,5,4,7,6,0,9,1,7,4,2};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int low,int middle,int high) {
		int tmp[] = new int[high - low + 1];
		// 记录第一个数组中需要遍历的下标
		int i = low;
		// 记录第二个数组中需要遍历的下标
		int j = middle + 1;
		// 记录临时数组的下标
		int k = 0;
		// 遍历两个数组中最小的数组
		while(i <= middle && j <= high) {
			if(arr[i] <= arr[j]) {
				tmp[k] = arr[i];
				i ++;
			}else {
				tmp[k] = arr[j];
				j ++;
			}
			k ++;
		}
		// 处理多余的数据
		while(i<=middle) {
			tmp[k] = arr[i];
			i ++;
			k ++;
		}
		while(j<=high) {
			tmp[k] = arr[j];
			j ++;
			k ++;
		}
		for(int t = 0; t < tmp.length; t ++) {
			arr[t + low] = tmp[t];
		}
		
		
	}
	
	public static void mergeSort(int[] arr) {
		mergeSort(arr,0,(arr.length - 1)/2,arr.length-1);
	}
}
