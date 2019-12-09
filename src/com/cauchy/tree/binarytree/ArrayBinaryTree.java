package com.cauchy.tree.binarytree;

/**
 * 
 * @author Cauchy
 * @ClassName ArrayBinaryTree.java
 * @Date 2019��12��9��
 * @Description ˳��洢������
 * @Version V0.1
 *
 */
public class ArrayBinaryTree {
	/*
	 * ���ڴ洢Ԫ��
	 */
	private int[] data;

	/**
	 * @Description ��ʼ��
	 * @param data ���ڳ�ʼ��������
	 */
	public ArrayBinaryTree(int[] data) {
		this.data = data;
	}

	/**
	 * 
	 * @param data
	 * @param index
	 * @Description ���������������
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
	 * @Description �������������
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
	 * @Description �������������
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
	 * @Description �������������
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
	 * @Description �������������
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
	 * @Description ����������
	 */
	public void postOrderTraval() {
		postOrderTraval(data, 0);
	}
}
