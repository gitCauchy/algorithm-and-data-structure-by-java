package com.cauchy.tree.avltree;

/**
 * 
 * @author Cauchy
 * @ClassName BinarySortTree.java
 * @Date 2019年12月16日
 * @Description 平衡二叉树
 * @Version
 *
 */
public class AVLTree {
	Node root;

	/**
	 * @param node
	 * @Description 向二叉树中添加节点
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
	 * @Description 二叉排序树中序遍历
	 */
	public void inOrderTraversal() {
		System.out.println("IN ORDER TRAVERSAL");
		root.inOrderTraversal();
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @Description 二叉排序树查找
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
	 * @Description 删除节点
	 */
	public void delete(int data) {
		if (root == null) {
			return;
		}
		// 找到这个节点
		Node target = search(data);
		if (target == null) {
			return;
		}
		// 找到父节点
		Node parent = searchParent(data);
		// 待删除的节点是叶子节点
		if (target.lNode == null && target.rNode == null) {
			// 要删除的元素是父节点的左子节点
			if (parent.lNode.data == data) {
				parent.lNode = null;
			}
			// 要删除的元素是父节点的右子节点
			if (parent.rNode.data == data) {
				parent.rNode = null;
			}
			// 待删除节点有两个叶子节点
		} else if (target.lNode != null && target.rNode != null) {
			// 删除右子树中最小的节点并获取到该节点的值
			int min = findMin(target.rNode);
			// 删除最小节点
			delete(min);
			// 替换目标节点中的值
			target.data = min;
			// 待删除节点有一个叶子节点
		} else {
			if (target.lNode != null) {
				// 当前节点是父节点的左子节点
				if (parent.lNode.data == data) {
					parent.lNode = target.lNode;
					// 当前节点是父节点的右子节点
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
	 * @Description 查找子树中最小的节点
	 */
	private int findMin(Node node) {
		Node target = node;

		while (node.lNode != null) {
			target = target.lNode;
		}
		// 删除最小的节点
		// delete(target.data);
		return target.data;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @Description 二叉树中节点查找
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
