package com.cauchy.tree.binarysorttree;

/**
 * 
 * @author Cauchy
 * @ClassName BinarySortTree.java
 * @Date 2019��12��16��
 * @Description ����������
 * @Version V0.1
 *
 */
public class BinarySortTree {
	/*
	 * ���ڵ�
	 */
	Node root;

	/**
	 * @param node
	 * @Description �����������ӽڵ�
	 */
	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	/**
	 * 
	 * @Description �����������������
	 */
	public void inOrderTraversal() {
		System.out.println("IN ORDER TRAVERSAL");
		root.inOrderTraversal();
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @Description ��������������
	 */
	public Node search(int data) {
		Node node = null;
		if (root == null) {
			return null;
		} else {
			node = root.search(data);
		}
		return node;
	}

	/**
	 * 
	 * @param data
	 * @Description ɾ���ڵ�
	 */
	public void delete(int data) {
		if (root == null) {
			return;
		}
		// �ҵ�����ڵ�
		Node target = search(data);
		if (target == null) {
			return;
		}
		// �ҵ����ڵ�
		Node parent = searchParent(data);
		// ��ɾ���Ľڵ���Ҷ�ӽڵ�
		if (target.lNode == null && target.rNode == null) {
			// Ҫɾ����Ԫ���Ǹ��ڵ�����ӽڵ�
			if (parent.lNode.data == data) {
				parent.lNode = null;
			}
			// Ҫɾ����Ԫ���Ǹ��ڵ�����ӽڵ�
			if (parent.rNode.data == data) {
				parent.rNode = null;
			}
			// ��ɾ���ڵ�������Ҷ�ӽڵ�
		} else if (target.lNode != null && target.rNode != null) {
			// ɾ������������С�Ľڵ㲢��ȡ���ýڵ��ֵ
			int min = findMin(target.rNode);
			// ɾ����С�ڵ�
			delete(min);
			// �滻Ŀ��ڵ��е�ֵ
			target.data = min;
			// ��ɾ���ڵ���һ��Ҷ�ӽڵ�
		} else {
			if (target.lNode != null) {
				// ��ǰ�ڵ��Ǹ��ڵ�����ӽڵ�
				if (parent.lNode.data == data) {
					parent.lNode = target.lNode;
					// ��ǰ�ڵ��Ǹ��ڵ�����ӽڵ�
				} else {
					parent.rNode = target.lNode;
				}
			} else { // target.rNode != null
				if (parent.lNode.data == data) {
					parent.lNode = target.rNode;
				} else {
					parent.rNode = target.rNode;
				}
			}
		}
	}

	/**
	 * 
	 * @param node
	 * @return
	 * @Description ����һ����������С�ڵ�
	 */
	private int findMin(Node node) {
		Node target = node;
		while (node.lNode != null) {
			target = target.lNode;
		}
		return target.data;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @Description ����һ���ڵ�ĸ��ڵ�
	 */
	public Node searchParent(int data) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(data);
		}
	}

	public String toString() {
		return "BinarySortTree [root=" + root + "]";
	}

}
