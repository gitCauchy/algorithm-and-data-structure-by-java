package com.cauchy.tree.binarysorttree;

/**
 * 
 * @author Cauchy
 * @ClassName Node.java
 * @Date 2019��12��17��
 * @Description ����������-�ڵ�
 * @Version V0.1
 *
 */
public class Node {
	/*
	 * ����
	 */
	int data;
	/*
	 * ��ڵ�
	 */
	Node lNode;
	/*
	 * �ҽڵ�
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
	 * @Description ����������ӽڵ�
	 */
	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (this.data >= node.data) {
			// ����ڵ�Ϊ��ֱ�Ӳ��뵽����ڵ��λ��
			if (this.lNode == null) {
				this.lNode = node;
			} else {
				// ����ڵ㲻Ϊ�գ��ݹ�
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
	 * @Description ����������������� ����Ľ����Ϊ�����Ľ��
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
	 * @Description ��������������
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
	 * @Description �������������Ҹ��ڵ�
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
