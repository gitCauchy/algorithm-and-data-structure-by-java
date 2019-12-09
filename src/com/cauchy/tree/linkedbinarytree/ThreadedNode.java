package com.cauchy.tree.linkedbinarytree;

public class ThreadedNode {
	/*
	 * 数据
	 */
	int data;
	/*
	 * 左子节点
	 */
	ThreadedNode lNode;
	/*
	 * 右子节点
	 */
	ThreadedNode rNode;
	/*
	 * 左指针类型
	 */
	int lType;
	/*
	 * 右指针类型
	 */
	int rType;
	
	/**
	 * @Description 先序遍历
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
	 * @Description 中序遍历
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
	 * @Description 后序遍历
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
	 * @Description 先序查找
	 */
	public ThreadedNode preOrderSearch(int x){
		ThreadedNode target = null;
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
	 * @Description 中序查找
	 */
	public ThreadedNode inOrderSearch(int x){
		ThreadedNode target = null;
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
	 * @Description 后序查找
	 */
	public ThreadedNode postOrderSearch(int x){
		ThreadedNode target = null;
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
	
	public ThreadedNode(int data) {
		this.data = data;
	}
	
	public ThreadedNode getlNode() {
		return lNode;
	}
	
	public void setlNode(ThreadedNode lNode) {
		this.lNode = lNode;
	}
	
	public ThreadedNode getrNode() {
		return rNode;
	}
	
	public void setrNode(ThreadedNode rNode) {
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
	 * @Description 删除节点
	 */
	public void delete(int x) {
		ThreadedNode parent = this;
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
