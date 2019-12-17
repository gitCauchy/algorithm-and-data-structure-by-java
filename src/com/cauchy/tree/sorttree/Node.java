package com.cauchy.tree.sorttree;

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
		// ����Ƿ���ƽ�������
		if(lNodeHeight() - rNodeHeight() >= 2) { // ����ת
			if(lNode != null && lNode.lNodeHeight() < lNode.rNodeHeight()) {
				lNode.leftRotate();
			}
			rightRotate();
		}
		if(lNodeHeight() - rNodeHeight() >= -2) { // ����ת
//			if(rNode != null && rNode.rNodeHeight() < ) {
//				// ��ȫ����
//			}
			leftRotate();
		}
	}

	private void leftRotate() {
		// TODO Auto-generated method stub
		
	}

	private void rightRotate() {
		// 1����һ���½ڵ㣬ֵΪ��ǰ�ڵ��ֵ
		Node newRight = new Node(this.data);
		// 2�ѵ�ǰ�ڵ�������������½ڵ��������
		newRight.rNode = this.rNode;
		// 3���½ڵ������������Ϊ��ǰ�ڵ���������������
		newRight.lNode = this.lNode.rNode;
		// 4�ѵ�ǰ�ڵ��ֵ����Ϊ���ӽڵ��ֵ
		this.data = this.lNode.data;
		// 5�ѵ�ǰ�ڵ������������Ϊ��������������
		this.lNode = this.lNode.lNode;
		// 6��ǰ�ڵ������������Ϊ�ҽڵ�
		this.rNode = newRight;
		
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
	
	public int height() {
		return Math.max(lNode==null? 0:lNode.height(), rNode == null ? 0: rNode.height()) + 1;
	}
	
	public int lNodeHeight() {
		if(lNode == null) {
			return 0;
		}
		return lNode.height();
	}
	
	public int rNodeHeight() {
		if(rNode == null) {
			return 0;
		}
		return rNode.height();
	}
	
	
}
