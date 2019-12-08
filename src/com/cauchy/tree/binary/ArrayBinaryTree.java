package com.cauchy.tree.binary;

public class ArrayBinaryTree {
	int [] data;

	public ArrayBinaryTree(int[] data) {
		//super();
		this.data = data;
	}
	
	public void preOrderTraval(int[] data,int index) {
		if(data == null || data.length == 0) {
			return;
		}
		System.out.println(data[index]);
		if(2*index+1 < data.length) {
			preOrderTraval(data, 2*index + 1);
		}
		if(2 *(index + 1) < data.length) {
			preOrderTraval(data,2*index + 2);
		}
	}
	
	public void preOrderTraval(int[] data) {
		preOrderTraval(data, 0);
	}
	
}
