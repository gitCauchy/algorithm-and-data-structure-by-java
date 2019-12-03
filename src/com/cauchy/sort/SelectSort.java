package com.cauchy.sort;

import java.util.Arrays;
/**
 * 
 * @author Cauchy
 * @ClassName SelectSort.java
 * @Date 2019��12��3��
 * @Description ѡ������
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
		// �������е�Ԫ��
		for(int i = 0; i < arr.length; i ++) {
			int minIndex = i;
			// ����ǰ�����ĺͺ������е�ֵ���бȽ�,����¼��С���±�
			for(int j = i + 1; j < arr.length ; j ++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			// �����С�����͵�ǰ������ֵ�����
			if(i != minIndex) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
}
