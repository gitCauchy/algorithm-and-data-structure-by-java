package com.cauchy.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HuffmanTree {
	public static Node createHuffmanTree(int[] arr) {
		List<Node> nodes = new ArrayList<Node>();
		// 排序
		for(int value : arr) {
			nodes.add(new Node(value));
		}
		// 循环处理
		while(nodes.size() > 1) {
			Collections.sort(nodes);
			// 取出权值最小的两个子树
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			Node parent = new Node(left.value + right.value);
			parent.lNode = left;
			parent.rNode = right;
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		//System.out.println(nodes);
		return nodes.get(0);
	}
	
	public static void main(String[] args) {
		int[] arr = {3,7,8,29,5,11,23,14};
		Node node = createHuffmanTree(arr);
	}
}
