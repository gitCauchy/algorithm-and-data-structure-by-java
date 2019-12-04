package com.cauchy.stack;

import java.util.Arrays;

/**
 * 
 * @author Cauchy
 * @ClassName Stack.java
 * @Date 2019年12月4日
 * @Description 栈
 * @Version V0.1
 *
 */
public class Stack {
	/*
	 * 初始化长度为10
	 */
	private static final int INITSIZE = 10;
	/*
	 * 存储元素的数组
	 */
	private int[] elements;
	/*
	 * 游标
	 */
	int index = 0;

	/**
	 * @description 判断是否为空栈
	 * @return 是否为空栈
	 */
	public boolean isEmpty() {
		return index == 0;
	}

	/**
	 * @description 初始化栈
	 */
	public Stack() {
		elements = new int[INITSIZE];
	}

	/**
	 * @description 压栈操作
	 * @param e 压入的数据元素
	 */
	public void push(int e) {
		if (index < 9) {
			elements[index++] = e;
		} else {
			int newArray[] = new int[elements.length * 2];
			System.arraycopy(elements, 0, newArray, 0, elements.length);
			elements = newArray;
			elements[index++] = e;
			// index ++;
		}
	}

	/**
	 * @description 弹栈操作
	 * @return 弹出的元素
	 */
	public int pop() {
		int e = elements[--index];
		// index --;
		if (index < elements.length / 2 && index > 10) {
			int newArray[] = new int[elements.length / 2];
			System.arraycopy(elements, 0, newArray, 0, elements.length);
			elements = newArray;
		}
		return e;
	}

	/**
	 * @description 返回栈深度
	 * @return 栈深度
	 */
	public int size() {
		return index;
	}

	public String toString() {
		return "Stack [elements=" + Arrays.toString(elements) + ", index=" + index + "]";
	}

}
