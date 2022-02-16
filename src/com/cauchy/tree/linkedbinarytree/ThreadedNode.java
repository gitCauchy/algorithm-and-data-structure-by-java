package com.cauchy.tree.linkedbinarytree;

/**
 *
 * @author Cauchy
 * @ClassName ThreadedNode.java
 * @Date 2019年12月12日
 * @Description 线索二叉树节点
 * @Version V0.1
 *
 */
public class ThreadedNode {
    /*
     * 数据
     */
    int data;
    /*
     * 左子节点
     */
    ThreadedNode lNode;
    /*
     * 右子节点
     */
    ThreadedNode rNode;
    /*
     * 左指针类型
     */
    int lType;
    /*
     * 右指针类型
     */
    int rType;

    public ThreadedNode(int data) {
        this.data = data;
    }

    public String toString() {
        return "TreeNode [ value=" + data + "]";
    }

}
