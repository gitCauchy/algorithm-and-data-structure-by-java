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
		// ��¼��һ����������Ҫ�������±�
		int i = low;
		// ��¼�ڶ�����������Ҫ�������±�
		int j = middle + 1;
		// ��¼��ʱ������±�
		int k = 0;
		// ����������������С������
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
		// ������������
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
