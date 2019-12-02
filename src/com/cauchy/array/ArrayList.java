package com.cauchy.array;

import java.util.Arrays;

/**
 * 
 * @author Cauchy
 * @ClassName ArrayList.java
 * @Date 2019��12��2��
 * @Description ���Ա�
 * @Version 0.1
 *
 */
public class ArrayList {
	/*
	 * �洢Ԫ������
	 */
	private Integer[] elements;
	/*
	 * �α�
	 */
	private int index = 0;

	/*
	 * ��ʼ��
	 */
	public ArrayList() {
		elements = new Integer[5];
	}

	/**
	 * @return ����ĳ���
	 */
	public int size() {
		return index;
	}

	/**
	 * 
	 * @param e   Ҫ��ӵ�Ԫ��
	 * @param loc Ԫ����ӵ�λ��
	 */
	public void add(int e, int loc) {
		if (index < elements.length) { // ��������
			if (loc <= index) { // �����С�ڵ�ǰ�α�
				for (int i = index + 1; i > loc; i--) {
					elements[i] = elements[i - 1];
				}
				elements[loc] = e;
				index++;
			} else { // ���������αֱ꣬�Ӳ��뵽ĩβ
				elements[index] = e;
				index++;
			}
		} else { // ����
			Integer[] newArr = new Integer[size() * 2];
			System.arraycopy(elements, 0, newArr, 0, size());
			elements = newArr;
			add(e, loc);
		}
	}

	/**
	 * @description ��ӵ�ĩβ
	 * @param e ��ӵ�Ԫ��
	 */
	public void add(int e) {
		add(e, index);
	}

	/**
	 * 
	 * @param loc ɾ��Ԫ�ص�λ��
	 */
	public void delete(int loc) {
		for (int i = loc; i <= index; i++) {
			elements[i] = elements[i + 1];
		}
		index--;
	}

	public String toString() {
		return "ArrayList [elements=" + Arrays.toString(elements) + ", index=" + index + "]";
	}

	/**
	 * 
	 * @param loc λ��
	 * @return ָ��λ�õ�Ԫ��
	 */
	public Integer get(int loc) {
		return elements[loc];
	}
}
