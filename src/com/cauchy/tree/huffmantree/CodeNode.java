package com.cauchy.tree.huffmantree;

/**
 * 
 * @author Cauchy
 * @ClassName CodeNode.java
 * @Date 2019��12��16��
 * @Description �շ�������ڵ�
 * @Version V0.1
 *
 */
public class CodeNode implements Comparable<CodeNode> {
	/*
	 * Ȩֵ
	 */
	int weight;
	/*
	 * ��ڵ�
	 */
	CodeNode lNode;
	/*
	 * �ҽڵ�
	 */
	CodeNode rNode;
	/*
	 * ����
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
