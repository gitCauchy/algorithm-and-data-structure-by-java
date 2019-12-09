package com.cauchy.sort;

import java.util.Arrays;

/**
 * 
 * @author Cauchy
 * @ClassName HeapSort.java
 * @Date 2019��12��9��
 * @Description ������
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
		// �ҵ������ӽڵ�
		int lNode = 2*index + 1;
		int rNode = 2*index + 2;
		int max = index;
		// �������ӽڵ���жԱȣ��ҵ����Ľڵ�
		if(lNode < size&&arr[lNode] > arr[max]) {
			max = lNode;
		}
		if(rNode < size&&arr[rNode] > arr[max]) {
			max = rNode;
		}
		// ��������λ��
		if(max != index) {
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
			// ����λ�ú���ܻ��ƻ�֮ǰ�źõĶѣ���Ҫ���µ���
			maxHeap(arr,size,max);
		}
	}
	
	public static void heapSort(int arr[]) {
		int start = (arr.length - 1) / 2;
		for(int i = start; i >= 0; i --) {
			maxHeap(arr,arr.length,i);
		}
		// �����ֵ�ƶ������һ��Ҷ�ӽڵ�,�ٰ�ǰ��Ĵ���ɴ󶥶�
		for(int i = arr.length -1 ; i > 0; i --) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeap(arr,i,0);
		}
	}
}
