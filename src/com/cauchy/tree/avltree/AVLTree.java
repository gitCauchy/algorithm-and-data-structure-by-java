package com.cauchy.tree.avltree;

/**
 * 
 * @author Cauchy
 * @ClassName BinarySortTree.java
 * @Date 2019��12��16��
 * @Description ƽ�������
 * @Version
 *
 */
public class AVLTree {
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
	
	public int height() {
		return root.height();
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
	 * @Description ������������С�Ľڵ�
	 */
	private int findMin(Node node) {
		Node target = node;

		while (node.lNode != null) {
			target = target.lNode;
		}
		// ɾ����С�Ľڵ�
		// delete(target.data);
		return target.data;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @Description �������нڵ����
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

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		for (int i : arr) {
			tree.add(new Node(i));
		}
		tree.inOrderTraversal();
		int h = tree.height();
		System.out.println(h);
//		Node node = tree.search(5);
//		System.out.println(node);
	}
}
