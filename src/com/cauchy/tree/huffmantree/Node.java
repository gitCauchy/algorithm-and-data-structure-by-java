package com.cauchy.tree.huffmantree;

/**
 * 
 * @author Cauchy
 * @ClassName Node.java
 * @Date 2019年12月16日
 * @Description 赫夫曼树节点
 * @Version V0.1
 *
 */
public class Node implements Comparable<Node> {
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
