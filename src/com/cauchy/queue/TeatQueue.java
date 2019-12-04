package com.cauchy.queue;

public class TeatQueue {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		int size = q.size();
		boolean isEm = q.isEmpty();
		int x1 = q.deQueue();
		int x2 = q.deQueue();
		int x3 = q.deQueue();
		int x4 = q.deQueue();
		int x5 = q.deQueue();
		
	}
}
