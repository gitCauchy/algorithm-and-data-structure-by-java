package com.cauchy.queue;

import java.util.Arrays;

/**
 * 
 * @author Cauchy
 * @ClassName Queue.java
 * @Date 2019年12月3日
 * @Description 队列
 * @Version v0.1
 *
 */
public class Queue {
	
	/*
	 * 初始化长度
	 */
	private static final int INITSIZE = 10;
	/*
	 * 数组存储
	 */
	int [] elements;
	/**
	 * @description 初始化队列
	 */
	public Queue() {
		elements = new int[INITSIZE];
	}
	/*
	 * 队头游标
	 */
	private int front = 0;
	/*
	 * 队尾游标
	 */
	private int rear= 0;
	/**
	 * @description 队列长度
	 * @return 队列长度
	 */
	public int size() {
		return front - rear;
	}
	/**
	 * @description 队列是否为空
	 * @return 是否为空
	 */
	public boolean isEmpty() {
		return front == rear;
	}
	/**
	 * @description 进队操作
	 * @param e 进队元素
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
	 * @description 出队操作
	 * @return 出队元素
	 */
	public int deQueue() {
		int e = elements[rear ++];
		//rear ++;
		// 如果尾部在数组中的位置已经到了1/2位置需要整体移动一次
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
