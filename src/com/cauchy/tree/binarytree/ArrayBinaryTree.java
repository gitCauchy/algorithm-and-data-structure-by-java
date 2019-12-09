package com.cauchy.tree.binarytree;

/**
 * 
 * @author Cauchy
 * @ClassName ArrayBinaryTree.java
 * @Date 2019年12月9日
 * @Description 顺序存储二叉树
 * @Version V0.1
 *
 */
public class ArrayBinaryTree {
	/*
	 * 用于存储元素
	 */
	private int[] data;

	/**
	 * @Description 初始化
	 * @param data 用于初始化的数组
	 */
	public ArrayBinaryTree(int[] data) {
		this.data = data;
	}

	/**
	 * 
	 * @param data
	 * @param index
	 * @Description 二叉树的先序遍历
	 */
	private void preOrderTraval(int[] data, int index) {
		if (data == null || data.length == 0) {
			return;
		}
		System.out.println(data[index] + "-");
		if (2 * index + 1 < data.length) {
			preOrderTraval(data, 2 * index + 1);
		}
		if (2 * (index + 1) < data.length) {
			preOrderTraval(data, 2 * index + 2);
		}
	}
	/**
	 * @Description 二叉树先序遍历
	 */
	public void preOrderTraval() {
		preOrderTraval(data, 0);
		System.out.println();
		System.out.println("-----data------");
	}
	/**
	 * 
	 * @param data
	 * @param index
	 * @Description 二叉树中序遍历
	 */
	private void inOrderTraval(int[] data,int index) {
		if( data == null || data.length == 0) {
			return;
		}
		if(2 * index + 1 < data.length) {
			inOrderTraval(data, 2 * index + 1);
		}
		System.out.print(data[index] + "-");
		if(2 * index + 2 < data.length) {
			inOrderTraval(data, 2 * index + 2);
		}
	}
	/**
	 * 
	 * @param data
	 * @Description 二叉树中序遍历
	 */
	public void inOrderTraval(int[] data) {
		inOrderTraval(data,0);
		System.out.println();
		System.out.println("-----data------");
	}
	/**
	 * 
	 * @param data
	 * @param index
	 * @Description 二叉树后序遍历
	 */
	private void postOrderTraval(int[] data,int index) {
		if( data == null || data.length == 0) {
			return;
		}
		if(2 * index + 1 < data.length) {
			postOrderTraval(data, 2 * index + 1);
		}
		if(2 * index + 2 < data.length) {
			postOrderTraval(data, 2 * index + 2);
		}
		System.out.print(data[index] + "-");
	}
	/**
	 * @Description 二叉树后序
	 */
	public void postOrderTraval() {
		postOrderTraval(data, 0);
	}
}
