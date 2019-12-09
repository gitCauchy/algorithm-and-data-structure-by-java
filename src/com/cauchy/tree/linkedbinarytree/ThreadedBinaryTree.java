package com.cauchy.tree.linkedbinarytree;

public class ThreadedBinaryTree {
	
	
	
	/*
	 * 根节点
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
	 * @Description 插入节点
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
	 * @Description 先序遍历二叉树
	 */
	public void preOrderTraversal() {
		root.preOrderTraversal();
	}
	/**
	 * @Description 中序遍历二叉树
	 */
	public void inOrderTraversal() {
		root.inOrderTraversal();
	}
	/**
	 * @Description 后序遍历二叉树
	 */
	public void postOrderTraversal() {
		root.postOrderTraversal();
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description 先序查找
	 */
	public ThreadedNode preOrderSearch(int x) {
		return root.preOrderSearch(x);
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description 中序查找
	 */
	public ThreadedNode inOrderSearch(int x) {
		return root.inOrderSearch(x);
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description 后序查找
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
	// 临时存储前驱节点
	ThreadedNode preNode = null;
	
	// 中序线索化二叉树
	public void threadBinaryTree(ThreadedNode node) {
		//当前节 点 如果为空，不处理
		if(node == null) {
			return;
		}
		// 处理左子树
		threadBinaryTree(node.lNode);
		// 处理前驱节点
		if(node.lNode == null) {
			// 当前节点的左指针指向前驱节点，改变左指针类型
			node.lNode = preNode;
			node.lType = 1;
		}
		// 处理前驱节点的右指针
		if(preNode != null && preNode.rNode == null) {
			preNode.rNode = node;
			preNode.rType = 1;
		}
		preNode = node;
		// 处理右子树
		threadBinaryTree(node.rNode);
	}
	
	public void threadIterator() {
		// 用于存储当前遍历的节点
		ThreadedNode node = root;
		if(node != null) {
			// 循环找到最开始的节点
			while(node.lType == 0) {
				node = node.lNode;
			}
			// 打印当前节点的值
			System.out.println(node.data);
			node = node.rNode;
			// 如果当前节点的右指针指向的是后继节点，可能后继节点还有后继节点
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
