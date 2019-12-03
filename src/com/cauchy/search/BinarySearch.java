package com.cauchy.search;
/**
 * 
 * @author Cauchy
 * @ClassName BinarySearch.java
 * @Date 2019年12月3日
 * @Description 二分查找
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
			// 判断中间元素是否是要查找的元素
			if(arr[mid] == target) {
				index = mid;
				break;
			}else {
				// 判断中间这个元素是否大于目标值
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
