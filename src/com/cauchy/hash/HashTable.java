package com.cauchy.hash;

public class HashTable {
	/*
	 * ʹ���������洢
	 */
	private TestData[] dataArr = new TestData[10];
	/**
	 * 
	 * @param data 
	 * @Description ���Ԫ��
	 */
	public void put(TestData data) {
		int index = data.hashCode();
		dataArr[index] = data;
	}
	/**
	 * 
	 * @param key
	 * @return
	 * @Description ��ȡԪ��
	 */
	public TestData get(int key) {
		int index = TestData.hashCode(key);
		return dataArr[index];
	}
}
