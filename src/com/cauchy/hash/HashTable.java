package com.cauchy.hash;

public class HashTable {
	/*
	 * 使用数组作存储
	 */
	private TestData[] dataArr = new TestData[10];
	/**
	 * 
	 * @param data 
	 * @Description 存放元素
	 */
	public void put(TestData data) {
		int index = data.hashCode();
		dataArr[index] = data;
	}
	/**
	 * 
	 * @param key
	 * @return
	 * @Description 获取元素
	 */
	public TestData get(int key) {
		int index = TestData.hashCode(key);
		return dataArr[index];
	}
}
