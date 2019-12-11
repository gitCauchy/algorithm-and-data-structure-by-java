package com.cauchy.tree.huffmantree;

public class Node implements Comparable<Node>{
	/*
	 * 权值
	 */
	int value;
	/*
	 * 左节点
	 */
	Node lNode;
	/*
	 * 右节点
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
