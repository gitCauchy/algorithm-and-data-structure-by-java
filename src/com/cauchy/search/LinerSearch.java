package com.cauchy.search;
/**
 * 
 * @author Cauchy
 * @ClassName LinerSearch.java
 * @Date 2019��12��2��
 * @Description ���Բ���
 * @Version v0.1
 *
 */
public class LinerSearch {
	public static int search(Integer [] array ,Integer target) {
		int index = -1;
		for(int i = 0; i < array.length; i ++) {
			if(array[i] == target) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		Integer [] arrtest = new Integer[] {1,3,5,7,9,2,4,6,8,10};
		int x = search(arrtest,6);
		System.out.println(x);
		
	}
}
