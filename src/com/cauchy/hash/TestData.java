package com.cauchy.hash;

public class TestData {
	/*
	 * ��
	 */
	int key;
	/*
	 * ֵ
	 */
	int value;
	/**
	 * @description ȡ�෨ɢ�к���
	 */
	public int hashCode() {
		return key % 10;
	}
	
	public static int hashCode(int key) {
		return key % 10;
	}
	
	public TestData(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public String toString() {
		return "TestData [key=" + key + ", value=" + value + "]";
	}
}
