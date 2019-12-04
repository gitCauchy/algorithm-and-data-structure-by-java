package com.cauchy.stack;

import java.util.Arrays;

/**
 * 
 * @author Cauchy
 * @ClassName Stack.java
 * @Date 2019��12��4��
 * @Description ջ
 * @Version V0.1
 *
 */
public class Stack {
	/*
	 * ��ʼ������Ϊ10
	 */
	private static final int INITSIZE = 10;
	/*
	 * �洢Ԫ�ص�����
	 */
	private int[] elements;
	/*
	 * �α�
	 */
	int index = 0;

	/**
	 * @description �ж��Ƿ�Ϊ��ջ
	 * @return �Ƿ�Ϊ��ջ
	 */
	public boolean isEmpty() {
		return index == 0;
	}

	/**
	 * @description ��ʼ��ջ
	 */
	public Stack() {
		elements = new int[INITSIZE];
	}

	/**
	 * @description ѹջ����
	 * @param e ѹ�������Ԫ��
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
	 * @description ��ջ����
	 * @return ������Ԫ��
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
	 * @description ����ջ���
	 * @return ջ���
	 */
	public int size() {
		return index;
	}

	public String toString() {
		return "Stack [elements=" + Arrays.toString(elements) + ", index=" + index + "]";
	}

}
