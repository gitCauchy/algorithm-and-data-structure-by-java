package com.cauchy.tree.binarytree;

public class BinaryTree {
	/*
	 * 根节点
	 */
	TreeNode root;
	
	public BinaryTree() {
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
	public TreeNode buildTreeNode(int data,TreeNode fNode,String nodeType) throws Exception{
		TreeNode node = new TreeNode(data);
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
	public TreeNode preOrderSearch(int x) {
		return root.preOrderSearch(x);
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description 中序查找
	 */
	public TreeNode inOrderSearch(int x) {
		return root.inOrderSearch(x);
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description 后序查找
	 */
	public TreeNode postOrderSearch(int x) {
		return root.postOrderSearch(x);
	}
	
	public void deleteNode(int x) {
		if(root.data == x) {
			root = null;
		}else {
			root.delete(x);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BinaryTree tree = new BinaryTree();
		tree.root = tree.buildTreeNode(1, null, null);
		TreeNode n21 = tree.buildTreeNode(2, tree.root, "left");
		TreeNode n22 = tree.buildTreeNode(3, tree.root, "right");
		TreeNode n31 = tree.buildTreeNode(4, n21, "left");
		TreeNode n32 = tree.buildTreeNode(5, n21, "right");
		TreeNode n33 = tree.buildTreeNode(6, n22, "left");
		TreeNode n34 = tree.buildTreeNode(7, n22, "right");
		//tree.preOrderTraversal();
		//tree.inOrderTraversal();
		//tree.postOrderTraversal();
		TreeNode five = tree.preOrderSearch(5);
		System.out.println(five);
		
	}
}
