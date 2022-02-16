package com.cauchy.tree.binarytree;

/**
 *
 * @author Cauchy
 * @ClassName ArrayBinaryTree.java
 * @Date 2019年12月9日
 * @Description 顺序存储二叉树
 * @Version V1.0
 *
 */
public class ArrayBinaryTree {

    /*
     * 用于存储元素
     */
    private int[] data;

    /**
     * @Description 二叉树先序遍历
     */
    public void preOrderTraval() {
        System.out.println("--PRE ORDER TRAVERSAL--");
        preOrderTraval(data, 0);
        System.out.println();
    }

    /**
     * @Description 二叉树中序遍历
     */
    public void inOrderTraval() {
        System.out.println("--IN ORDER TRAVERSAL--");
        inOrderTraval(data, 0);
        System.out.println();
    }

    /**
     * @Description 二叉树后序遍历
     */
    public void postOrderTraval() {
        System.out.println("--POST ORDER TRAVERSAL--");
        postOrderTraval(data, 0);
        System.out.println();
    }

    /**
     * @Description 二叉树的水平遍历
     */
    public void levelTraversal() {
        if (data == null || data.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int elem : data) {
            sb.append(elem + "-");
        }
        System.out.println("--LEVEL TRAVERSAL--");
        String result = sb.substring(0, sb.length() - 1);
        System.out.println(result);
    }

    /**
     * @Description 初始化
     * @param data 用于初始化的数组
     */
    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    /**
     *
     * @param data
     * @param index
     * @Description 二叉树的先序遍历
     */
    private void preOrderTraval(int[] data, int index) {
        if (data == null || data.length == 0) {
            return;
        }
        System.out.print(data[index] + "-");
        if (2 * index + 1 < data.length) {
            preOrderTraval(data, 2 * index + 1);
        }
        if (2 * (index + 1) < data.length) {
            preOrderTraval(data, 2 * index + 2);
        }
    }

    /**
     *
     * @param data
     * @param index
     * @Description 二叉树中序遍历
     */
    private void inOrderTraval(int[] data, int index) {
        if (data == null || data.length == 0) {
            return;
        }
        if (2 * index + 1 < data.length) {
            inOrderTraval(data, 2 * index + 1);
        }
        System.out.print(data[index] + "-");
        if (2 * index + 2 < data.length) {
            inOrderTraval(data, 2 * index + 2);
        }
    }

    /**
     *
     * @param data
     * @param index
     * @Description 二叉树后序遍历
     */
    private void postOrderTraval(int[] data, int index) {
        if (data == null || data.length == 0) {
            return;
        }
        if (2 * index + 1 < data.length) {
            postOrderTraval(data, 2 * index + 1);
        }
        if (2 * index + 2 < data.length) {
            postOrderTraval(data, 2 * index + 2);
        }
        System.out.print(data[index] + "-");
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayBinaryTree tree = new ArrayBinaryTree(data);
        tree.levelTraversal();
        tree.preOrderTraval();
        tree.inOrderTraval();
        tree.postOrderTraval();
    }
}
