package com.cauchy.list;

import java.util.Arrays;

/**
 * @author Cauchy
 * @ClassName ArrayList.java
 * @Date 2021年11月30日
 * @Description 线性表
 * @Version v0.3
 */
public class ArrayList {

    private static final int INITSIZE = 10;

    /**
     * 存储元素数组
     */
    private Integer[] elements;
    /**
     * 游标
     */
    private int index = 0;

    /**
     * 无参数构造方法
     */
    public ArrayList() {
        elements = new Integer[INITSIZE];
    }

    /**
     *
     * @param element
     * @return 如果找到指定元素，从线性表中删除，并返回 true,如果没找到指定的元素，返回 false
     */
    public boolean remove(Integer element){
        return false;
    }

    /**
     *
     * @param index 待移除元素的下标
     * @return 移除的元素
     */
    public Integer remove(int index) {
        // 找到指定位置的元素
        Integer element = elements[index];
        for (int i = index; i <= elements.length; i++) {
            elements[index] = elements[index + 1];
        }
        return element;
    }

    /**
     * @param element 待查找元素
     * @return 找到指定元素 返回 true 未找到返回 false
     */
    public boolean contains(Integer element){
        // 遍历数组，查看是否包含该元素
        for(Integer elem : elements) {
            // 遍历途中 如果找到了指定元素，直接返回 true
            if (elem.equals(element)) {
                return true;
            }
        }
        return false;
    }



    /**
     * @return 数组的长度
     * @description 线性表长度
     */
    public int size() {
        return index;
    }

    public Integer set(int index,Integer element){
        return null;
    }

    /**
     *
     * @param element 待查找坐标的元素
     * @return 该元素的下标,如果不存在，返回 -1
     */
    public int indexOf(Integer element){
        for(int i = 0; i< size();i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param a 数组引用
     * @return
     */
    public Integer[] toArray(Integer[] a){
        a = elements;
        return a;
    }

    /**
     * 清除线性表中的元素
     */
    public void clear(){
        index = 0;
    }
    public boolean equals(){
        return false;
    }

    @Override
    public int hashCode(){
        return 0;
    }
    public boolean isEmpty(){
        return false;
    }

    public int lastIndexOf(Integer element){
        return 0;
    }

    /**
     * @param e   要添加的元素
     * @param loc 元素添加的位置
     * @description 添加元素
     */
    public void add(int e, int loc) {
        // 无需扩容
        if (index < elements.length) {
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
     * @param e 添加的元素
     * @description 向末尾添加元素
     * @description 添加到末尾
     */
    public void add(int e) {
        add(e, index);
    }

    /**
     * @param loc 删除元素的位置
     * @description 删除元素
     */
    public void delete(int loc) {
        for (int i = loc; i <= index; i++) {
            elements[i] = elements[i + 1];
        }
        index--;
    }

    @Override
    public String toString() {

        return "ArrayList [elements=" + Arrays.toString(elements) + ", index=" + index + "]";
    }

    /**
     * @param loc 位置
     * @return 指定位置的元素
     * @description
     */
    public Integer get(int loc) {
        return elements[loc];
    }
}
