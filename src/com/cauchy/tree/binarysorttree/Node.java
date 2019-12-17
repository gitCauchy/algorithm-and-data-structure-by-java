package com.cauchy.tree.binarysorttree;

/**
 * 
 * @author Cauchy
 * @ClassName Node.java
 * @Date 2019年12月17日
 * @Description 二叉排序树-节点
 * @Version V0.1
 *
 */
public class Node {
	/*
	 * 数据
	 */
	int data;
	/*
	 * 左节点
	 */
	Node lNode;
	/*
	 * 右节点
	 */
	Node rNode;

	public Node(int data) {
		this.data = data;
	}

	public String toString() {
		return "Node [data=" + data + "]";
	}

	/**
	 * 
	 * @param node
	 * @Description 向子树中添加节点
	 */
	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (this.data >= node.data) {
			// 如果节点为空直接插入到这个节点的位置
			if (this.lNode == null) {
				this.lNode = node;
			} else {
				// 如果节点不为空，递归
				this.lNode.add(node);
			}
		} else {
			if (this.rNode == null) {
				this.rNode = node;
			} else {
				this.rNode.add(node);
			}
		}
	}

	/**
	 * @Description 二叉排序树中序遍历 输出的结果即为排序后的结果
	 */
	public void inOrderTraversal() {
		if (lNode != null) {
			lNode.inOrderTraversal();
		}
		System.out.print(data + "-");
		if (rNode != null) {
			rNode.inOrderTraversal();
		}
	}

	/**
	 * @param data
	 * @return
	 * @Description 二叉排序树查找
	 */
	public Node search(int data) {
		Node node = null;
		if (this.data == data) {
			node = this;
		} else if (this.data > data) {
			node = lNode.search(data);
		} else {
			node = rNode.search(data);
		}
		return node;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @Description 二叉排序树查找父节点
	 */

	public Node searchParent(int data) {
		if ((this.lNode != null && this.lNode.data == data) || (this.rNode != null && this.rNode.data == data)) {
			return this;
		} else if (this.data > data && this.lNode != null) {
			return this.lNode.searchParent(data);
		} else if (this.data < data && this.rNode != null) {
			return this.rNode.searchParent(data);
		} else {
			return null;
		}
	}
}
