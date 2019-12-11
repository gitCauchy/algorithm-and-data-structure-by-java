package com.cauchy.tree.huffmantree;

public class Node implements Comparable<Node>{
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
		if(this.value == o.value) {
			return 0;
		}else if(this.value > o.value) {
			return -1;
		}else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	
	
	

}
