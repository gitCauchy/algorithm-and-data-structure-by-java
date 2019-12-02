package com.cauchy.array;

import java.util.Arrays;

/**
 * 
 * @author Cauchy
 * @ClassName ArrayList.java
 * @Date 2019年12月2日
 * @Description 线性表
 * @Version 0.1
 *
 */
public class ArrayList {
	/*
	 * 存储元素数组
	 */
	private Integer[] elements;
	/*
	 * 游标
	 */
	private int index = 0;

	/*
	 * 初始化
	 */
	public ArrayList() {
		elements = new Integer[5];
	}

	/**
	 * @return 数组的长度
	 */
	public int size() {
		return index;
	}

	/**
	 * 
	 * @param e   要添加的元素
	 * @param loc 元素添加的位置
	 */
	public void add(int e, int loc) {
		if (index < elements.length) { // 无需扩容
			if (loc <= index) { // 插入点小于当前游标
				for (int i = index + 1; i > loc; i--) {
					elements[i] = elements[i - 1];
				}
				elements[loc] = e;
				index++;
			} else { // 插入点大于游标，直接插入到末尾
				elements[index] = e;
				index++;
			}
		} else { // 扩容
			Integer[] newArr = new Integer[size() * 2];
			System.arraycopy(elements, 0, newArr, 0, size());
			elements = newArr;
			add(e, loc);
		}
	}

	/**
	 * @description 添加到末尾
	 * @param e 添加的元素
	 */
	public void add(int e) {
		add(e, index);
	}

	/**
	 * 
	 * @param loc 删除元素的位置
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
	 * @param loc 位置
	 * @return 指定位置的元素
	 */
	public Integer get(int loc) {
		return elements[loc];
	}
}
