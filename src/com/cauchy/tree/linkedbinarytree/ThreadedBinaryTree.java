package com.cauchy.tree.linkedbinarytree;

/**
 * 
 * @author Cauchy
 * @ClassName ThreadedBinaryTree.java
 * @Date 2019��12��12��
 * @Description ����������
 * @Version V0.1
 *
 */
public class ThreadedBinaryTree {
	/*
	 * ���ڵ�
	 */
	ThreadedNode root;

	/*
	 * ��ʱ�洢ǰ���ڵ�
	 */
	ThreadedNode preNode = null;

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
	public ThreadedNode buildTreeNode(int data, ThreadedNode fNode, String nodeType) throws Exception {
		ThreadedNode node = new ThreadedNode(data);
		if (fNode != null) {
			if (nodeType.equals("left")) {
				fNode.lNode = node;
			} else if (nodeType.equals("right")) {
				fNode.rNode = node;
			} else {
				throw new Exception("No such type node");
			}
		}
		return node;
	}

	/**
	 * @Description ��������������
	 */
	public void threadPreOrderBinaryTree() {
		threadPreOrderBinaryTree(root);
	}

	/**
	 * @Description ��������������
	 */
	public void threadInOrderBinaryTree() {
		threadInOrderBinaryTree(root);
	}

	/**
	 * @Description ������������
	 */
	public void threadInOrderIterator() {
		// ���ڴ洢��ǰ�����Ľڵ�
		ThreadedNode node = root;
		while (node != null) {
			// ѭ���ҵ��ʼ�Ľڵ�
			while (node.lType == 0) {
				node = node.lNode;
			}
			// ��ӡ��ǰ�ڵ��ֵ
			System.out.println(node.data);
			// �����ǰ�ڵ����ָ��ָ����Ǻ�̽ڵ㣬���ܺ�̽ڵ㻹�к�̽ڵ�
			while (node.rType == 1) {
				node = node.rNode;
				System.out.println(node.data);
			}
			// �滻�����Ľڵ�
			node = node.rNode;
		}
	}

	/**
	 * @param x
	 * @Description ɾ���ڵ�
	 */
	public void deleteNode(int x) {

	}

	private void threadPreOrderBinaryTree(ThreadedNode node) {
		// ����ǰ�ڵ�
		if (node.lNode == null) {
			node.lNode = preNode;
			node.lType = 1;
		}
		if (preNode != null && preNode.rNode == null) {
			preNode.rNode = node;
			preNode.rType = 1;
		}
		preNode = node;
		// ������ڵ�
		if (node.lNode != null && node.lType == 0) {
			threadPreOrderBinaryTree(node.lNode);
		}
		// �����ҽڵ�
		if (node.rNode != null && node.rType == 0) {
			threadPreOrderBinaryTree(node.rNode);
		}
	}

	/**
	 * @param node
	 * @Description ��������������
	 */
	private void threadInOrderBinaryTree(ThreadedNode node) {
		// ����������
		if (node.lNode != null) {
			threadInOrderBinaryTree(node.lNode);
		}
		// ����ǰ���ڵ�
		if (node.lNode == null) {
			// ��ǰ�ڵ����ָ��ָ��ǰ���ڵ㣬�ı���ָ������
			node.lNode = preNode;
			node.lType = 1;
		}
		// ����ǰ���ڵ����ָ��
		if (preNode != null && preNode.rNode == null) {
			// ���ǰ���ڵ����ָ��Ϊ�գ�ָ��˽ڵ�
			preNode.rNode = node;
			preNode.rType = 1;
		}
		// ÿ����һ���ڵ㣬����ڵ������һ���ڵ�ĵ�ǰ���ڵ�
		preNode = node;
		// ����������
		if (node.rNode != null) {
			threadInOrderBinaryTree(node.rNode);
		}
	}

	public static void main(String[] args) throws Exception {
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		tree.root = tree.buildTreeNode(1, null, null);
		ThreadedNode n21 = tree.buildTreeNode(2, tree.root, "left");
		ThreadedNode n22 = tree.buildTreeNode(3, tree.root, "right");
		ThreadedNode n31 = tree.buildTreeNode(4, n21, "left");
		ThreadedNode n32 = tree.buildTreeNode(5, n21, "right");
		ThreadedNode n33 = tree.buildTreeNode(6, n22, "left");
		ThreadedNode n34 = tree.buildTreeNode(7, n22, "right");
		// tree.preOrderTraversal();
		// tree.threadInOrderBinaryTree();
		tree.threadPreOrderBinaryTree();
		// tree.threadPreOrderIterator(tree.root);
	}
}
