package com.cauchy.tree.huffmantree;

/**
 * 
 * @author Cauchy
 * @ClassName Node.java
 * @Date 2019��12��16��
 * @Description �շ������ڵ�
 * @Version V0.1
 *
 */
public class Node implements Comparable<Node> {
	/*
	 * Ȩֵ
	 */
	int value;
	/*
	 * ��ڵ�
	 */
	Node lNode;
	/*
	 * �ҽڵ�
	 */
	Node rNode;

	public Node(int value) {
		this.value = value;
	}

	public int compareTo(Node o) {
		if (this.value == o.value) {
			return 0;
		} else if (this.value > o.value) {
			return -1;
		} else {
			return 1;
		}
	}

	public String toString() {
		return "Node [value=" + value + "]";
	}
}
