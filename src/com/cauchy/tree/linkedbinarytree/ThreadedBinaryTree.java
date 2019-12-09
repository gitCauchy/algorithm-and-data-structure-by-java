package com.cauchy.tree.linkedbinarytree;

public class ThreadedBinaryTree {
	
	
	
	/*
	 * ���ڵ�
	 */
	ThreadedNode root;
	
	public ThreadedBinaryTree() {
		root = null;
	}
	/**
	 * 
	 * @param data
	 * @param fNode
	 * @param nodeType
	 * @return
	 * @throws Exception 
	 * @Description ����ڵ�
	 */
	public ThreadedNode buildTreeNode(int data,ThreadedNode fNode,String nodeType) throws Exception{
		ThreadedNode node = new ThreadedNode(data);
		if(fNode != null) {
			if(nodeType.equals("left")) {
				fNode.lNode = node;
			}else if(nodeType.equals("right")) {
				fNode.rNode = node;
			}else {
				throw new Exception("No such type node");
			}
		}
		return node;
	}
	/**
	 * @Description �������������
	 */
	public void preOrderTraversal() {
		root.preOrderTraversal();
	}
	/**
	 * @Description �������������
	 */
	public void inOrderTraversal() {
		root.inOrderTraversal();
	}
	/**
	 * @Description �������������
	 */
	public void postOrderTraversal() {
		root.postOrderTraversal();
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description �������
	 */
	public ThreadedNode preOrderSearch(int x) {
		return root.preOrderSearch(x);
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description �������
	 */
	public ThreadedNode inOrderSearch(int x) {
		return root.inOrderSearch(x);
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description �������
	 */
	public ThreadedNode postOrderSearch(int x) {
		return root.postOrderSearch(x);
	}
	
	public void deleteNode(int x) {
		if(root.data == x) {
			root = null;
		}else {
			root.delete(x);
		}
	}
	// ��ʱ�洢ǰ���ڵ�
	ThreadedNode preNode = null;
	
	// ����������������
	public void threadBinaryTree(ThreadedNode node) {
		//��ǰ�� �� ���Ϊ�գ�������
		if(node == null) {
			return;
		}
		// ����������
		threadBinaryTree(node.lNode);
		// ����ǰ���ڵ�
		if(node.lNode == null) {
			// ��ǰ�ڵ����ָ��ָ��ǰ���ڵ㣬�ı���ָ������
			node.lNode = preNode;
			node.lType = 1;
		}
		// ����ǰ���ڵ����ָ��
		if(preNode != null && preNode.rNode == null) {
			preNode.rNode = node;
			preNode.rType = 1;
		}
		preNode = node;
		// ����������
		threadBinaryTree(node.rNode);
	}
	
	public void threadIterator() {
		// ���ڴ洢��ǰ�����Ľڵ�
		ThreadedNode node = root;
		if(node != null) {
			// ѭ���ҵ��ʼ�Ľڵ�
			while(node.lType == 0) {
				node = node.lNode;
			}
			// ��ӡ��ǰ�ڵ��ֵ
			System.out.println(node.data);
			node = node.rNode;
			// �����ǰ�ڵ����ָ��ָ����Ǻ�̽ڵ㣬���ܺ�̽ڵ㻹�к�̽ڵ�
			while(node.rType == 1) {
				node = node.rNode;
				System.out.println(node.data);
			}
			node = node.rNode;
		}
	}
	
	public void threadBinaryTree() {
		threadBinaryTree(root);
	}
}
