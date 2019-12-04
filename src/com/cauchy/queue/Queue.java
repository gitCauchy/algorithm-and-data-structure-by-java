package com.cauchy.queue;

import java.util.Arrays;

/**
 * 
 * @author Cauchy
 * @ClassName Queue.java
 * @Date 2019��12��3��
 * @Description ����
 * @Version v0.1
 *
 */
public class Queue {
	
	/*
	 * ��ʼ������
	 */
	private static final int INITSIZE = 10;
	/*
	 * ����洢
	 */
	int [] elements;
	/**
	 * @description ��ʼ������
	 */
	public Queue() {
		elements = new int[INITSIZE];
	}
	/*
	 * ��ͷ�α�
	 */
	private int front = 0;
	/*
	 * ��β�α�
	 */
	private int rear= 0;
	/**
	 * @description ���г���
	 * @return ���г���
	 */
	public int size() {
		return front - rear;
	}
	/**
	 * @description �����Ƿ�Ϊ��
	 * @return �Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return front == rear;
	}
	/**
	 * @description ���Ӳ���
	 * @param e ����Ԫ��
	 */
	public void enQueue(int e) {
		if(front < elements.length) {
			elements[front ++] = e;
		}else {
			int[] newArray = new int[elements.length * 2];
			System.arraycopy(elements, 0, newArray, 0, elements.length);
			elements = newArray;
			elements[front ++] = e;
		}
	}
	/**
	 * @description ���Ӳ���
	 * @return ����Ԫ��
	 */
	public int deQueue() {
		int e = elements[rear ++];
		//rear ++;
		// ���β���������е�λ���Ѿ�����1/2λ����Ҫ�����ƶ�һ��
		if(rear >= elements.length/2) {
			int newArray[] = new int [elements.length];
			System.arraycopy(elements, rear, newArray, 0, front - rear);
			rear = 0;
			front -= rear;
		}
		return e;
	}
	@Override
	public String toString() {
		return "Queue [elements=" + Arrays.toString(elements) + ", front=" + front + ", rear=" + rear + "]";
	}
	
	

}
