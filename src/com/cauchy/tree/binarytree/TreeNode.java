package com.cauchy.tree.binarytree;

public class TreeNode {
	/*
	 * ���ӽڵ�
	 */
	TreeNode lNode;
	/*
	 * ���ӽڵ�
	 */
	TreeNode rNode;
	/*
	 * ֵ
	 */
	int data;
	
	/**
	 * @Description �������
	 */
	public void preOrderTraversal() {
		System.out.print(this.data + "-");
		if(lNode != null) {
			lNode.preOrderTraversal();
		}
		if(rNode != null) {
			rNode.preOrderTraversal();
		}
	}
	/**
	 * @Description �������
	 */
	public void inOrderTraversal() {
		if(lNode != null) {
			lNode.inOrderTraversal();
		}
		System.out.print(this.data + "-");
		if(rNode != null) {
			rNode.inOrderTraversal();
		}
	}
	/**
	 * @Description �������
	 */
	public void postOrderTraversal() {
		
		if(lNode != null) {
			lNode.postOrderTraversal();
		}
		if(rNode != null) {
			rNode.postOrderTraversal();
		}
		System.out.print(this.data + "-");
	}
	/**
	 * 
	 * @param x
	 * @return Node
	 * @Description �������
	 */
	public TreeNode preOrderSearch(int x){
		TreeNode target = null;
		if(this.data == x) {
			return this;
		}else {
			if(lNode != null) {
				target = lNode.preOrderSearch(x);
			}
			if(target != null) {
				return target;
			}
			if(rNode != null) {
				target = rNode.preOrderSearch(x);
			}
			if(target != null) {
				return target;
			}
		}
		return target;
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description �������
	 */
	public TreeNode inOrderSearch(int x){
		TreeNode target = null;
		if(lNode != null) {
			target = lNode.inOrderSearch(x);
		}
		if(target != null) {
			return target;
		}
		if(this.data == x) {
			target = this;
			return target;
		}else {
			if(rNode != null) {
				target = rNode.inOrderSearch(x);
			}
		}
		return target;
	}
	/**
	 * 
	 * @param x
	 * @return
	 * @Description �������
	 */
	public TreeNode postOrderSearch(int x){
		TreeNode target = null;
		if(lNode != null) {
			target = lNode.postOrderSearch(x);
		}
		if(target == null) {
			if(rNode != null) {
				target = rNode.postOrderSearch(x);
			}
			if(target == null) {
				if(this.data == x) {
					return this;
				}
			}
		}
		return target;
	}
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public TreeNode getlNode() {
		return lNode;
	}
	
	public void setlNode(TreeNode lNode) {
		this.lNode = lNode;
	}
	
	public TreeNode getrNode() {
		return rNode;
	}
	
	public void setrNode(TreeNode rNode) {
		this.rNode = rNode;
	}
	
	public int getValue() {
		return data;
	}
	
	public void setValue(int data) {
		this.data = data;
	}
	
	public void setValue() {
		
	}

	public String toString() {
		return "TreeNode [ value=" + data + "]";
	}
	/**
	 * 
	 * @param x
	 * @Description ɾ���ڵ�
	 */
	public void delete(int x) {
		TreeNode parent = this;
		if(parent.lNode != null && parent.lNode.data == x) {
			parent.lNode = null;
			return;
		}else if(parent.rNode != null && parent.rNode.data == x) {
			parent.rNode = null;
			return;
		}else {
			parent = lNode;
			if(parent != null) {
				parent.delete(x);
			}
			parent = rNode;
			if(parent != null) {
				parent.delete(x);
			}
		}
	}
}
