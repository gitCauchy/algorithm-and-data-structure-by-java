package com.cauchy.list;


/**
 * 
 * @author Cauchy
 * @ClassName CircleList.java
 * @Date 2019年12月3日
 * @Description 循环链表
 * @Version V0.1
 *
 */
public class CircleList {
	public class Node{
		int data;
		Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public Node() {
			
		}
		
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}

	}

	private Node head;
	
	public CircleList() {
		//head.next = head;
		Node node = new Node();
		head = node;
		head.next = head;
	}
	
	/**
	 * @description 链表长度
	 * @return 链表长度
	 */
	public int size() {
		int size = 0;
		Node p = head;
		while (p.next != head) {
			size++;
			p = p.next;
		}
		size ++;
		return size;
	}
	/**
	 * @description 插入元素
	 * @param loc 位置
	 * @param e 待插入元素
	 */
	public void insert(int loc, int e) {
		// 先找到loc - 1 位置：
		if (loc == 0) {
			//Node node = new Node(e,null);
			head.data = e;
			//node.next = head;
			//head = node;
		} else {
			Node node = new Node(e,null);
			node.data = e;
			Node p = head;
			for (int i = 0; i < loc - 1; i++) {
				p = p.next;
			}
			node.next = p.next;
			p.next = node;
		}
	}
	/**
	 * @description 删除链表中某个节点的元素
	 * @param loc 在链表中的位置
	 */
	public void delete(int loc) {
		Node p = head;
		for (int i = 0; i < loc - 1; i++) {
			p = p.next;
		}
		p.next = p.next.next;
	}
	/**
	 * @description 判断链表是否为空链
	 * @return 是否为空
	 */
	public boolean isEmpty() {
		return head.next == head;
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
	/**
	 * @description 获取某个元素在链表中的位置
	 * @param loc 链表中的位置
	 * @return data 节点中的元素
	 */
	public int getElem(int loc) {
		Node p = head;
		for (int i = 0; i < loc; i++) {
			p = p.next;
		}
		return p.data;
	}
	/**
	 * @description 获取某个位置元素在链表中的位置
	 * @param e 节点的元素
	 * @return loc 元素的位置
	 */
	public int getLocation(int e) {
		int loc = 0;
		Node p = head;
		while (p.data != e) {
			p = p.next;
			loc++;
		}
		return loc;
	}

	public String toString() {
		return "LinkedList [head=" + head + "]";
	}
		
}
