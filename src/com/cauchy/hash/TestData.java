package com.cauchy.hash;

public class TestData {
    /*
     * 键
     */
    int key;
    /*
     * 值
     */
    int value;
    /**
     * @description 取余法散列函数
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
