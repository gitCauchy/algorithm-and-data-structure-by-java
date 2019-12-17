package com.cauchy.tree.avltree;

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
		if(node == null) {
			return;
		}
		// �жϴ���Ľڵ�ֵ�ȵ�ǰ�Ľڵ����С
		if(node.data < this.data) {
			// �����ڵ�Ϊ��
			if(this.lNode == null) {
				this.lNode = node;
			}else {
				this.lNode.add(node);
			}
		}else {
			// ����ҽڵ�Ϊ��
			if(this.rNode == null) {
				this.rNode = node;
			}else {
				this.rNode.add(node);
			}
		}
	}

	public void inOrderTraversal() {
		if(lNode != null) {
			lNode.inOrderTraversal();
		}
		System.out.println(data);
		if(rNode != null) {
			rNode.inOrderTraversal();
		}
	}

	public Node search(int data) {
		Node node = null;
		if(this.data == data) {
			node = this;
		}else if(this.data > data) {
			node = lNode.search(data);
		}else {
			node = rNode.search(data);
		}
		return node;
	}

	public Node searchParent(int data) {
		if((this.lNode != null && this.lNode.data == data) || (this.rNode != null && this.rNode.data == data)) {
			return this;
		}else if(this.data > data && this.lNode != null) {
			return this.lNode.searchParent(data);
		}else if(this.data < data && this.rNode != null){
			return this.rNode.searchParent(data);
		}else {
			return null;
		}
	}
}
