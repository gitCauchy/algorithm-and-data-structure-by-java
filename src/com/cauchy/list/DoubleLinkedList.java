package com.cauchy.list;

public class DoubleLinkedList {

    private class Node {
        int data;
        Node prior;
        Node next;


        public Node(int data, Node prior, Node next) {
            this.data = data;
            this.prior = prior;
            this.next = next;

        }

        public String toString() {
            return "Node{" + "data=" + data + ", prior=" + prior + ", next=" + next + '}';
        }
    }

    private Node head;

    public DoubleLinkedList() {
        head = null;
    }

    public DoubleLinkedList(Node head) {
        this.head = head;
    }

    /**
     * @return 链表长度
     * @description 链表长度
     */
    public int size() {
        int size = 0;
        Node p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    /**
     * @param loc 位置
     * @param e   待插入元素
     * @description 插入元素
     */
    public void insert(int loc, int e) {
        // 先找到 loc - 1 位置：
        Node node = new Node(e, null, null);
        node.data = e;
        if (loc == 0) {
            node.prior = null;
            node.next = head;
            head = node;
        } else {
            Node p = head;
            for (int i = 0; i < loc - 1; i++) {
                p = p.next;
            }
            node.prior = p.prior;
            node.next = p.next;
            p.next = node;
        }
    }

    /**
     * @param loc 在链表中的位置
     * @description 删除链表中某个节点的元素
     */
    public void delete(int loc) {
        Node p = head;
        for (int i = 0; i < loc - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    /**
     * @return 是否为空
     * @description 判断链表是否为空链
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * @description 链表遍历
     */
    public void traversal() {
        Node p = head;
        while (p != null) { // 某个节点的下一个节点不为空
            System.out.print(p.data + "--");
            p = p.next;
        }
    }

    /**
     * @param loc 链表中的位置
     * @return data 节点中的元素
     * @description 获取某个元素在链表中的位置
     */
    public int getElem(int loc) {
        Node p = head;
        for (int i = 0; i < loc; i++) {
            p = p.next;
        }
        return p.data;
    }

    /**
     * @param e 节点的元素
     * @return loc 元素的位置
     * @description 获取某个位置元素在链表中的位置
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


    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList();
        dl.insert(0, 0);
        dl.insert(0, 1);
        dl.insert(0, 2);
        dl.insert(0, 3);

        dl.traversal();
    }
}
