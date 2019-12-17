package com.cauchy.tree.avltree;

/**
 * 
 * @author Cauchy
 * @ClassName Node.java
 * @Date 2019年12月17日
 * @Description 平衡二叉树节点
 * @Version
 *
 */
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

	/**
	 * 
	 * @param node
	 * @Description 向子树中添加节点
	 */
	public void add(Node node) {
		if (node == null) {
			return;
		}
		// 判断传入的节点值比当前的节点大还是小
		if (node.data < this.data) {
			// 如果左节点为空
			if (this.lNode == null) {
				this.lNode = node;
			} else {
				this.lNode.add(node);
			}
		} else {
			// 如果右节点为空
			if (this.rNode == null) {
				this.rNode = node;
			} else {
				this.rNode.add(node);
			}
		}
		// 检查是否是平衡二叉树
		if (lNodeHeight() - rNodeHeight() >= 2) { // 右旋转
			if (lNode != null && lNode.lNodeHeight() < lNode.rNodeHeight()) {
				lNode.leftRotate();
			}
			rightRotate();
		}
		if (lNodeHeight() - rNodeHeight() >= -2) { // 左旋转
			if (rNode != null && rNode.rNodeHeight() < rNode.lNodeHeight()) {
				rNode.rightRotate();
			}
			leftRotate();
		}
	}

	private void leftRotate() {
		// 1 创建一个新节点
		Node newLeft = new Node(this.data);
		// 2 新节点的左节点为当前节点的左节点的值
		newLeft.lNode = this.lNode;
		// 3新节点的右节点为当前节点右节点的左节点
		newLeft.rNode = this.rNode.lNode;
		// 4当前节点的值设置为当前节点右节点的值
		this.data = this.rNode.data;
		// 5当前节点的右节点为右节点的右节点
		this.rNode = this.rNode.rNode;
		// 6左节点设置为当前节点的左节点
		this.lNode = newLeft;
	}

	private void rightRotate() {
		// 1创建一个新节点，值为当前节点的值
		Node newRight = new Node(this.data);
		// 2把当前节点的右子树等于新节点的右子树
		newRight.rNode = this.rNode;
		// 3把新节点的左子树设置为当前节点左子树的右子树
		newRight.lNode = this.lNode.rNode;
		// 4把当前节点的值设置为左子节点的值
		this.data = this.lNode.data;
		// 5把当前节点的左子树设置为左子树的左子树
		this.lNode = this.lNode.lNode;
		// 6当前节点的右子树设置为右节点
		this.rNode = newRight;
	}

	/**
	 * @Description 二叉排序树中序遍历
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
	 * 
	 * @param data
	 * @return
	 * @Description 查找节点
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
	 * @Description 查找父节点
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

	/**
	 * 
	 * @return
	 * @Description 二叉树高度
	 */
	public int height() {
		return Math.max(lNode == null ? 0 : lNode.height(), rNode == null ? 0 : rNode.height()) + 1;
	}

	/**
	 * 
	 * @return
	 * @Description 左子树高度
	 */
	public int lNodeHeight() {
		if (lNode == null) {
			return 0;
		}
		return lNode.height();
	}

	/**
	 * 
	 * @return
	 * @Description 获取右子树高度
	 */
	public int rNodeHeight() {
		if (rNode == null) {
			return 0;
		}
		return rNode.height();
	}

	public Node(int data) {
		this.data = data;
	}

	public String toString() {
		return "Node [data=" + data + "]";
	}

}
