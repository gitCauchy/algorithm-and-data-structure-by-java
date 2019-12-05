package com.cauchy.sort;
/**
 * 
 * @author Cauchy
 * @ClassName QuickSort.java
 * @Date 2019��12��3��
 * @Description ��������
 * @Version v0.1
 *
 */
public class QuickSort {
	public static void quickSort(int arr[], int begin, int end) {
		if(begin < end) {
			// ��׼����
			int standard = arr[begin];
			// ��¼��Ҫ������±�
			int low = begin;
			int high = end;
			// ѭ���ұȱ�׼С�ĺͱȱ�׼���
			while(low < high ) {
				while(low < high && standard <= arr[high]) {
					high --;
				}
				// �ұߵ����ֱȱ�׼Ԫ��С
				arr[low] = arr[high];
				while(low < high && arr[low] <= standard) {
					low ++;
				}
				arr[high] = arr[low];
			}
			// ������ָ��ָ���λ�õ�ֵ��ֵΪstandard
			arr[low] = standard;
			quickSort(arr,begin,low);
			quickSort(arr,low + 1,end);
			
		}
	}
	
	public static void quickSort(int arr[]) {
		quickSort(arr, 0, arr.length-1);
	}
}
