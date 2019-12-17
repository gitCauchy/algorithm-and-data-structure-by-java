package com.cauchy.tree.huffmantree;

/**
 * 
 * @author Cauchy
 * @ClassName CodeNode.java
 * @Date 2019年12月16日
 * @Description 赫夫曼编码节点
 * @Version V0.1
 *
 */
public class CodeNode implements Comparable<CodeNode> {
	/*
	 * 权值
	 */
	int weight;
	/*
	 * 左节点
	 */
	CodeNode lNode;
	/*
	 * 右节点
	 */
	CodeNode rNode;
	/*
	 * 数据
	 */
	Byte data;

	public CodeNode(int weight, Byte data) {
		this.weight = weight;
		this.data = data;
	}

	public int compareTo(CodeNode o) {
		if (o.weight > this.weight) {
			return 1;
		} else if (o.weight < this.weight) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return "CodeNode [weight=" + weight + ", data=" + data + "]";
	}
	
	
}
