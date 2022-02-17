package com.cauchy.tree.binarytree;

/**
 * 顺序存储二叉树
 *
 * @author Cauchy
 * @date 2022/02/17 15:08
 **/
public class ArrayBinaryTree {

    /**
     * 用于存储元素
     */
    private int[] data;

    /**
     * 二叉树的先序遍历
     */
    private void preOrderTraverse() {
        System.out.println("--PRE ORDER TRAVERSE--");
        preOrderTraverse(data, 0);
        System.out.println();
    }

    /**
     * 二叉树中序遍历
     */
    private void inOrderTraverse() {
        System.out.println("--IN ORDER TRAVERSE--");
        inOrderTraverse(data, 0);
        System.out.println();
    }

    /**
     * 二叉树后序遍历
     */
    private void postOrderTraverse() {
        System.out.println("--POST ORDER TRAVERSE--");
        postOrderTraverse(data, 0);
        System.out.println();
    }

    /**
     * 二叉树的水平遍历
     */
    private void levelTraverse() {
        if (data == null || data.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int elem : data) {
            sb.append(elem);
            sb.append("-");
        }
        System.out.println("--LEVEL TRAVERSE--");
        String result = sb.substring(0, sb.length() - 1);
        System.out.println(result);
    }

    /**
     * 初始化
     *
     * @param data 初始化的数组
     */
    private ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    /**
     * 二叉树先序遍历
     *
     * @param data  存储数组
     * @param index 索引
     */
    private void preOrderTraverse(int[] data, int index) {
        if (data == null || data.length == 0) {
            return;
        }
        System.out.print(data[index] + "-");
        if (2 * index + 1 < data.length) {
            preOrderTraverse(data, 2 * index + 1);
        }
        if (2 * (index + 1) < data.length) {
            preOrderTraverse(data, 2 * index + 2);
        }
    }

    /**
     * 二叉树中序遍历
     *
     * @param data  存储数组
     * @param index 索引
     */
    private void inOrderTraverse(int[] data, int index) {
        if (data == null || data.length == 0) {
            return;
        }
        if (2 * index + 1 < data.length) {
            inOrderTraverse(data, 2 * index + 1);
        }
        System.out.print(data[index] + "-");
        if (2 * index + 2 < data.length) {
            inOrderTraverse(data, 2 * index + 2);
        }
    }

    /**
     * 二叉树后序遍历
     *
     * @param data  存储数组
     * @param index 索引
     */
    private void postOrderTraverse(int[] data, int index) {
        if (data == null || data.length == 0) {
            return;
        }
        if (2 * index + 1 < data.length) {
            postOrderTraverse(data, 2 * index + 1);
        }
        if (2 * index + 2 < data.length) {
            postOrderTraverse(data, 2 * index + 2);
        }
        System.out.print(data[index] + "-");
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(data);
        tree.levelTraverse();
        tree.preOrderTraverse();
        tree.inOrderTraverse();
        tree.postOrderTraverse();
    }
}
