package com.cauchy.list;

/**
 * 
 * @author Cauchy
 * @ClassName DoubleCircleList.java
 * @Date 2019年12月3日
 * @Description 双循环链表
 * @Version V0.1
 *
 */
public class DoubleCircleList {
	private class Node{
		Node prior;
		int data;
		Node next;
		public Node(int data, Node prior,Node next) {
			
			this.prior = prior;
			this.data = data;
			this.next = next;
		}
		public Node() {
			//super();
		}
		
		
	}
	
	Node head;
	
	public DoubleCircleList() {

		Node node = new Node();
		head = node;
		head.next = head;
		head.prior = head;
	}
	
	public void insert(int loc, int e) {
		// 先找到loc - 1 位置：
		if (loc == 0) {
			head.data = e;
		} else {
			Node node = new Node(e,null,null);
			node.data = e;
			Node p = head;
			for (int i = 0; i < loc - 1; i++) {
				p = p.next;
			}
			node.next = p.next;
			p.next = node;
			node.prior = p;
		}
	}
	
	/**
	 * @description 删除链表中某个节点的元素
	 * @param loc 在链表中的位置
	 */
	public void delete(int loc) {
		Node p = head;
		for (int i = 0; i < loc ; i++) {
			p = p.next;
		}
		//p.next = p.next.next;
		p.prior.next = p.next;
		p.next.prior = p.prior;
	}
	/**
	 * @description 判断链表是否为空链
	 * @return 是否为空
	 */
	public boolean isEmpty() {
		return head.next == head;
	}

	@Override
	public String toString() {
		return "DoubleCircleList [head=" + head + "]";
	}
	
	/**
	 *@description 链表遍历
	 */
	public void traversal() {
		Node p = head;
		while (p.next != head) { // 某个节点的下一个节点不为空
			System.out.print(p.data + "--");
			p = p.next;
		}
		System.out.println(p.data);
	}
}
