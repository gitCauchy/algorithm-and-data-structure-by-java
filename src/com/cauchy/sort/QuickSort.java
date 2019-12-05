package com.cauchy.sort;
/**
 * 
 * @author Cauchy
 * @ClassName QuickSort.java
 * @Date 2019年12月3日
 * @Description 快速排序
 * @Version v0.1
 *
 */
public class QuickSort {
	public static void quickSort(int arr[], int begin, int end) {
		if(begin < end) {
			// 基准数字
			int standard = arr[begin];
			// 记录需要排序的下标
			int low = begin;
			int high = end;
			// 循环找比标准小的和比标准大的
			while(low < high ) {
				while(low < high && standard <= arr[high]) {
					high --;
				}
				// 右边的数字比标准元素小
				arr[low] = arr[high];
				while(low < high && arr[low] <= standard) {
					low ++;
				}
				arr[high] = arr[low];
			}
			// 将两个指针指向的位置的值赋值为standard
			arr[low] = standard;
			quickSort(arr,begin,low);
			quickSort(arr,low + 1,end);
			
		}
	}
	
	public static void quickSort(int arr[]) {
		quickSort(arr, 0, arr.length-1);
	}
}
