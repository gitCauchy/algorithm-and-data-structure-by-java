package com.cauchy.search;
/**
 * 
 * @author Cauchy
 * @ClassName BinarySearch.java
 * @Date 2019��12��3��
 * @Description ���ֲ���
 * @Version v0.1
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = new int[] {1,2,3,4,5,6,7,8,9,10};
		int target = 8;
		int index = -1;
		int begin = 0;
		int end = arr.length -1;
		int mid = (begin + end) / 2;
		while(begin < end) {
			// �ж��м�Ԫ���Ƿ���Ҫ���ҵ�Ԫ��
			if(arr[mid] == target) {
				index = mid;
				break;
			}else {
				// �ж��м����Ԫ���Ƿ����Ŀ��ֵ
				if(arr[mid] < target) {
					begin = mid;
					mid = (begin + end)/2;
				}else {
					end = mid;
					mid = (begin + end) /2;
				}
			}
			
		}
		System.out.println(index);
	}
}
