package com.cauchy.tree.avltree;
/**
 * 
 * @author Cauchy
 * @ClassName BinarySortTree.java
 * @Date 2019年12月16日
 * @Description 二叉排序树
 * @Version 
 *
 */
public class BinarySortTree {
	Node root;
	/**
	 * 
	 * @param node
	 * @Description 向二叉树中添加节点
	 */
	public void add(Node node) {
		if(root == null) {
			root = node;
		}else {
			root.add(node);
		}
	}
	
	public String toString() {
		return "BinarySortTree [root=" + root + "]";
	}
	
	public void inOrderTraversal() {
		root.inOrderTraversal();
	}

	public Node search(int data) {
		Node node = null;
		if(root == null) {
			return null;
		}else {
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
		if(root == null) {
			return;
		}else {
			// 找到这个节点
			Node target = search(data);
			if(target == null) {
				return;
			}else {
				// 找到父节点
				Node parent = searchParent(data);
				if(target.lNode == null && target.rNode == null) {
					// 要删除的元素是父节点的左子节点
					if(parent.lNode.data == data) {
						parent.lNode = null;
					}
					// 要删除的元素是父节点的右子节点
					if(parent.rNode.data == data) {
						parent.rNode = null;
					}
				}else if(target.lNode != null && target.rNode != null) {
					// 删除右子树中最小的节点并获取到该节点的值
					int min = deleteMin(target.rNode);
					// 替换目标节点中的值
					target.data = min;
				}else {
					if(target.lNode != null) {
						if(parent.lNode.data == data) {
							parent.lNode = target.lNode;
						}else {
							parent.rNode = target.lNode;
						}
					}else {
						if(parent.lNode.data == data) {
							parent.lNode = target.rNode;
						}else {
							parent.rNode = target.rNode;
						}
					}
				}
			}
			
		}
	}
	
	
	private int deleteMin(Node node) {
		Node target = node;
		
		while(node.lNode != null) {
			target = target.lNode;
		}
		// 删除最小的节点
		delete(target.data);
		return target.data;
	}

	public Node searchParent(int data) {
		if(root == null) {
			return null;
		}else {
			return root.searchParent(data);
		}
	}

	public static void main(String[] args) {
		BinarySortTree tree = new BinarySortTree();
		int[] arr = new int[] {7,3,10,12,5,1,9};
		for(int i : arr) {
			tree.add(new Node(i));
		}
		tree.inOrderTraversal();
		Node node = tree.search(10);
		System.out.println(node);
	}
}
