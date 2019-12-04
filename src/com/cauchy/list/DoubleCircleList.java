package com.cauchy.list;

/**
 * 
 * @author Cauchy
 * @ClassName DoubleCircleList.java
 * @Date 2019��12��3��
 * @Description ˫ѭ������
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
		// ���ҵ�loc - 1 λ�ã�
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
	 * @description ɾ��������ĳ���ڵ��Ԫ��
	 * @param loc �������е�λ��
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
	 * @description �ж������Ƿ�Ϊ����
	 * @return �Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return head.next == head;
	}

	@Override
	public String toString() {
		return "DoubleCircleList [head=" + head + "]";
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
}
