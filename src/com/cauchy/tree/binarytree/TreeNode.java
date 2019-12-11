package com.cauchy.tree.binarytree;

/**
 * 
 * @author Cauchy
 * @ClassName TreeNode.java
 * @Date 2019��12��11��
 * @Description �������ڵ�
 * @Version V0.1
 *
 */
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
		if (lNode != null) {
			lNode.preOrderTraversal();
		}
		if (rNode != null) {
			rNode.preOrderTraversal();
		}
	}

	/**
	 * @Description �������
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
	 * @Description �������
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
	 * @Description �������
	 */
	public TreeNode preOrderSearch(int x) {
		TreeNode target = null;
		if (this.data == x) {
			return this;
		} else {
			if (lNode != null) {
				target = lNode.preOrderSearch(x);
			}
			// �����������������в��ҵ�Ҫ���ҵ�ֵ��ֹͣ����
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
	 * @Description �������
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
	 * @Description �������
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
	 * @Description ɾ���ڵ�
	 */
	public void delete(int x) {
		TreeNode parent = this;
		// �����ڵ㲻Ϊ����ǡ��ΪҪ����ɾ���Ľڵ㣬�ͽ��ڵ�ɾ��
		if(parent.lNode != null && parent.lNode.data == x) {
			parent.lNode = null;
		}else if(parent.rNode != null && rNode.data == x) {// ����ҽڵ㲻Ϊ����ǡ��ΪҪ����ɾ���Ľڵ㣬�ͽ��ڵ�ɾ��
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
