package com.cauchy.tree.binarytree;

/**
 * 
 * @author Cauchy
 * @ClassName ArrayBinaryTree.java
 * @Date 2019��12��9��
 * @Description ˳��洢������
 * @Version V1.0
 *
 */
public class ArrayBinaryTree {

	/*
	 * ���ڴ洢Ԫ��
	 */
	private int[] data;

	/**
	 * @Description �������������
	 */
	public void preOrderTraval() {
		System.out.println("--PRE ORDER TRAVERSAL--");
		preOrderTraval(data, 0);
		System.out.println();
	}

	/**
	 * @Description �������������
	 */
	public void inOrderTraval() {
		System.out.println("--IN ORDER TRAVERSAL--");
		inOrderTraval(data, 0);
		System.out.println();
	}

	/**
	 * @Description �������������
	 */
	public void postOrderTraval() {
		System.out.println("--POST ORDER TRAVERSAL--");
		postOrderTraval(data, 0);
		System.out.println();
	}

	/**
	 * @Description ��������ˮƽ����
	 */
	public void levelTraversal() {
		if (data == null || data.length == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int elem : data) {
			sb.append(elem + "-");
		}
		System.out.println("--LEVEL TRAVERSAL--");
		String result = sb.substring(0, sb.length() - 1);
		System.out.println(result);
	}

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
		System.out.print(data[index] + "-");
		if (2 * index + 1 < data.length) {
			preOrderTraval(data, 2 * index + 1);
		}
		if (2 * (index + 1) < data.length) {
			preOrderTraval(data, 2 * index + 2);
		}
	}

	/**
	 * 
	 * @param data
	 * @param index
	 * @Description �������������
	 */
	private void inOrderTraval(int[] data, int index) {
		if (data == null || data.length == 0) {
			return;
		}
		if (2 * index + 1 < data.length) {
			inOrderTraval(data, 2 * index + 1);
		}
		System.out.print(data[index] + "-");
		if (2 * index + 2 < data.length) {
			inOrderTraval(data, 2 * index + 2);
		}
	}

	/**
	 * 
	 * @param data
	 * @param index
	 * @Description �������������
	 */
	private void postOrderTraval(int[] data, int index) {
		if (data == null || data.length == 0) {
			return;
		}
		if (2 * index + 1 < data.length) {
			postOrderTraval(data, 2 * index + 1);
		}
		if (2 * index + 2 < data.length) {
			postOrderTraval(data, 2 * index + 2);
		}
		System.out.print(data[index] + "-");
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayBinaryTree tree = new ArrayBinaryTree(data);
		tree.levelTraversal();
		tree.preOrderTraval();
		tree.inOrderTraval();
		tree.postOrderTraval();
	}
}
