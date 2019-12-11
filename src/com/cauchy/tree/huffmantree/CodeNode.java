package com.cauchy.tree.huffmantree;

public class CodeNode implements Comparable<CodeNode>{
	int weight;
	CodeNode lNode;
	CodeNode rNode;
	Byte data;
	public CodeNode(int weight, Byte data) {
		//super();
		this.weight = weight;
		this.data = data;
	}
	@Override
	public int compareTo(CodeNode o) {
		return o.weight - this.weight;
	}
}
