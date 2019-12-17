package com.cauchy.tree.avltree;
/**
 * 
 * @author Cauchy
 * @ClassName BinarySortTree.java
 * @Date 2019��12��16��
 * @Description ����������
 * @Version 
 *
 */
public class BinarySortTree {
	Node root;
	/**
	 * 
	 * @param node
	 * @Description �����������ӽڵ�
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
	 * @Description ɾ���ڵ�
	 */
	public void delete(int data) {
		if(root == null) {
			return;
		}else {
			// �ҵ�����ڵ�
			Node target = search(data);
			if(target == null) {
				return;
			}else {
				// �ҵ����ڵ�
				Node parent = searchParent(data);
				if(target.lNode == null && target.rNode == null) {
					// Ҫɾ����Ԫ���Ǹ��ڵ�����ӽڵ�
					if(parent.lNode.data == data) {
						parent.lNode = null;
					}
					// Ҫɾ����Ԫ���Ǹ��ڵ�����ӽڵ�
					if(parent.rNode.data == data) {
						parent.rNode = null;
					}
				}else if(target.lNode != null && target.rNode != null) {
					// ɾ������������С�Ľڵ㲢��ȡ���ýڵ��ֵ
					int min = deleteMin(target.rNode);
					// �滻Ŀ��ڵ��е�ֵ
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
		// ɾ����С�Ľڵ�
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
