package com.cauchy.tree.linkedbinarytree;

/**
 * 
 * @author Cauchy
 * @ClassName ThreadedNode.java
 * @Date 2019��12��12��
 * @Description �����������ڵ�
 * @Version V0.1
 *
 */
public class ThreadedNode {
	/*
	 * ����
	 */
	int data;
	/*
	 * ���ӽڵ�
	 */
	ThreadedNode lNode;
	/*
	 * ���ӽڵ�
	 */
	ThreadedNode rNode;
	/*
	 * ��ָ������
	 */
	int lType;
	/*
	 * ��ָ������
	 */
	int rType;

	public ThreadedNode(int data) {
		this.data = data;
	}

	public String toString() {
		return "TreeNode [ value=" + data + "]";
	}

}
