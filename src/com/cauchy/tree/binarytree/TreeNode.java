package com.cauchy.tree.binarytree;

/**
 * 
 * @author Cauchy
 * @ClassName TreeNode.java
 * @Date 2019年12月11日
 * @Description 二叉树节点
 * @Version V0.1
 *
 */
public class TreeNode {
	/*
	 * 左子节点
	 */
	TreeNode lNode;
	/*
	 * 右子节点
	 */
	TreeNode rNode;
	/*
	 * 值
	 */
	int data;

	/**
	 * @Description 先序遍历
	 */
	public void preOrderTraversal() {
		System.out.print(this.data + "-");
		if (lNode != null) {
			lNode.preOrderTraversal();
		}
		if (rNode != null) {
			rNode.preOrderTraversal();
		}
	}

	/**
	 * @Description 中序遍历
	 */
	public void inOrderTraversal() {
		if (lNode != null) {
			lNode.inOrderTraversal();
		}
		System.out.print(this.data + "-");
		if (rNode != null) {
			rNode.inOrderTraversal();
		}
	}

	/**
	 * @Description 后序遍历
	 */
	public void postOrderTraversal() {

		if (lNode != null) {
			lNode.postOrderTraversal();
		}
		if (rNode != null) {
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
	public TreeNode preOrderSearch(int x) {
		TreeNode target = null;
		if (this.data == x) {
			return this;
		} else {
			if (lNode != null) {
				target = lNode.preOrderSearch(x);
			}
			// 在左子树遍历过程中查找到要查找的值就停止查找
			if (target != null) {
				return target;
			}
			if (rNode != null) {
				target = rNode.preOrderSearch(x);
			}
			if (target != null) {
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
	public TreeNode inOrderSearch(int x) {
		TreeNode target = null;
		if (lNode != null) {
			target = lNode.inOrderSearch(x);
		}
		if (target != null) {
			return target;
		}
		if (this.data == x) {
			target = this;
			return target;
		} 
		if (rNode != null) {
			target = rNode.inOrderSearch(x);
		}
		return target;
	}

	/**
	 * 
	 * @param x
	 * @return
	 * @Description 后序查找
	 */
	public TreeNode postOrderSearch(int x) {
		TreeNode result = null;
		if(lNode != null) {
			result = lNode.postOrderSearch(x);
		}
		if(result != null) {
			return result;
		}else {
			if(rNode != null) {
				result = rNode.postOrderSearch(x);
			}
			if(result != null) {
				return result;
			}
			if(data == x) {
				return this;
			}
		}
		return result;
	}
	/**
	 * 
	 * @param x
	 * @Description 删除节点
	 */
	public void delete(int x) {
		TreeNode parent = this;
		// 如果左节点不为空且恰好为要查找删除的节点，就将节点删除
		if(parent.lNode != null && parent.lNode.data == x) {
			parent.lNode = null;
		}else if(parent.rNode != null && rNode.data == x) {// 如果右节点不为空且恰好为要查找删除的节点，就将节点删除
			parent.rNode = null;
		}else {
			parent = parent.lNode;
			if(parent != null) {
				parent.delete(x);
			}
			parent = parent.rNode;
			if(parent != null) {
				parent.delete(x);
			}
		}
	}
	
	public TreeNode(int data) {
		this.data = data;
	}

	public String toString() {
		return "TreeNode [ value=" + data + "]";
	}

	
}
