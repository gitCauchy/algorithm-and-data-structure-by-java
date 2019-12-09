package com.cauchy.tree.binarytree;

/**
 * 
 * @author Cauchy
 * @ClassName BinaryTree.java
 * @Date 2019��12��5��
 * @Description ������
 * @Version V0.1
 *
 */
public class BinaryTree {
	
	public class TreeNode{
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
		int value;
		/**
		 * @description ������ڵ�
		 * @param lNode 
		 */
		public void setlNode(TreeNode lNode) {
			this.lNode = lNode;
		}
		/**
		 * @description �����ҽڵ�
		 * @param rNode
		 */
		public void setrNode(TreeNode rNode) {
			this.rNode = rNode;
		}
		/**
		 * @description ����һ���ڵ�
		 * @param value
		 */
		public TreeNode(int value) {
			this.value = value;
		}
		
		public String toString() {
			return "TreeNode [value=" + value + "]";
		}

		public void preOrderTraversal() {
			System.out.print(this.value + "--");
			if(lNode != null) {
				lNode.preOrderTraversal();
			}
			if(rNode != null) {
				rNode.preOrderTraversal();
			}
		}
		
		public void inOrderTraversal() {
			if(lNode != null) {
				lNode.inOrderTraversal();
			}
			System.out.print(this.value + "--");
			if(rNode != null) {
				rNode.inOrderTraversal();
			}
		}
		
		public void postOrderTraversal() {
			
			if(lNode != null) {
				lNode.postOrderTraversal();
			}
			if(rNode != null) {
				rNode.postOrderTraversal();
			}
			System.out.print(this.value + "--");
		}
		
		public TreeNode preOrderSearch(int x){
			TreeNode target = null;
			if(this.value == x) {
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
		
		public TreeNode inOrderSearch(int x){
			TreeNode target = null;
			if(lNode != null) {
				target = lNode.inOrderSearch(x);
			}
			if(target != null) {
				return target;
			}
			if(this.value == x) {
				target = this;
				return target;
			}else {
				if(rNode != null) {
					target = rNode.inOrderSearch(x);
				}
			}
			return target;
		}
		
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
					if(this.value == x) {
						return this;
					}
				}
			}
			return target;
		}
		// ɾ��һ������
		public void delete(int x) {
			TreeNode parent = this;
			if(parent.lNode != null && parent.lNode.value == x) {
				parent.lNode = null;
				return;
			}else if(parent.rNode != null && parent.rNode.value == x) {
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

	BinaryTree.TreeNode root;
	
	/**
	 * @description ����һ�ſ���
	 */
	public BinaryTree() { 
		root = null;
	}



	/**
	 * 
	 * @param data
	 * @param fNode
	 * @param nodeType
	 * @return �½����Ľڵ�
	 * @throws Exception
	 */
	public TreeNode setTreeNode(int data,TreeNode fNode,String nodeType) throws Exception {
		
		BinaryTree.TreeNode node = this.new TreeNode(data);
		if(fNode != null) {
			if(nodeType.equals("left")) {
				fNode.setlNode(node);
			}else if(nodeType.equals("right")){
				fNode.setrNode(node);
			}else {
				throw new Exception("No such Type Node");
			}
		}
		
		return node;
	}
	/**
	 * @description �����������
	 */
	public void preOrderTraversal() {
		root.preOrderTraversal();
	}
	/**
	 * @description �����������
	 */
	public void inOrderTraversal() {
		root.inOrderTraversal();
	}
	/**
	 * @description ���ĺ������
	 */
	public void postOrderTraversal() {
		root.postOrderTraversal();
	}
	
	public TreeNode preOrderSearch(int x) {
		return root.preOrderSearch(x);
	}
	
	public TreeNode inOrderSearch(int x) {
		return root.inOrderSearch(x);
	}
	
	public TreeNode postOrderSearch(int x) {
		return root.postOrderSearch(x);
	}
	
	public void deleteNode(int x) {
		if(root.value == x) {
			//root.delete(x);
			root = null;
		}else {
			root.delete(x);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BinaryTree tree = new BinaryTree();
		//BinaryTree tree = new BinaryTree(this.setTreeNode(0, null, null));
		tree.root = tree.setTreeNode(1, null, null);
		BinaryTree.TreeNode n21 = tree.setTreeNode(2, tree.root, "left");
		BinaryTree.TreeNode n22 = tree.setTreeNode(3, tree.root, "right");
		BinaryTree.TreeNode n31 = tree.setTreeNode(4, n21, "left");
		BinaryTree.TreeNode n32 = tree.setTreeNode(5, n21, "right");
		BinaryTree.TreeNode n33 = tree.setTreeNode(6, n22, "left");
		BinaryTree.TreeNode n34 = tree.setTreeNode(7, n22, "right");
		
		tree.deleteNode(2);
		// �������
		tree.preOrderTraversal();
//		System.out.println();
//		// �������
//		tree.inOrderTraversal();
//		System.out.println();
//		// �������
//		tree.postOrderTraversal();
		System.out.println("---------------------");
//		TreeNode result = tree.preOrderSearch(2);
//		TreeNode result1 = tree.inOrderSearch(2);
//		TreeNode result2 = tree.postOrderSearch(2);
//		System.out.println(result);
//		System.out.println(result1);
//		System.out.println(result2);
	}
	
	
	
	
}
