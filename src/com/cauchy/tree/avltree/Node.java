package com.cauchy.tree.avltree;

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
		if(node == null) {
			return;
		}
		// 判断传入的节点值比当前的节点大还是小
		if(node.data < this.data) {
			// 如果左节点为空
			if(this.lNode == null) {
				this.lNode = node;
			}else {
				this.lNode.add(node);
			}
		}else {
			// 如果右节点为空
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
