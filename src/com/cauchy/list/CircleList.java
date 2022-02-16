package com.cauchy.list;


/**
 * 
 * @author Cauchy
 * @ClassName CircleList.java
 * @Date 2019��12��3��
 * @Description ѭ������
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
	 * @description ������
	 * @return ������
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
	 * @description ����Ԫ��
	 * @param loc λ��
	 * @param e ������Ԫ��
	 */
	public void insert(int loc, int e) {
		// ���ҵ�loc - 1 λ�ã�
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
	 * @description ɾ��������ĳ���ڵ��Ԫ��
	 * @param loc �������е�λ��
	 */
	public void delete(int loc) {
		Node p = head;
		for (int i = 0; i < loc - 1; i++) {
			p = p.next;
		}
		p.next = p.next.next;
	}
	/**
	 * @description �ж������Ƿ�Ϊ����
	 * @return �Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return head.next == head;
	}
	/**
	 *@description �������
	 */
	public void traversal() {
		Node p = head;
		while (p.next != head) { // ĳ���ڵ����һ���ڵ㲻Ϊ��
			System.out.print(p.data + "--");
			p = p.next;
		}
		System.out.println(p.data);
	}
	/**
	 * @description ��ȡĳ��Ԫ���������е�λ��
	 * @param loc �����е�λ��
	 * @return data �ڵ��е�Ԫ��
	 */
	public int getElem(int loc) {
		Node p = head;
		for (int i = 0; i < loc; i++) {
			p = p.next;
		}
		return p.data;
	}
	/**
	 * @description ��ȡĳ��λ��Ԫ���������е�λ��
	 * @param e �ڵ��Ԫ��
	 * @return loc Ԫ�ص�λ��
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
