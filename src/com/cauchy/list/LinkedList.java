package com.cauchy.list;

/**
 * @author Cauchy
 * @ClassName LinkedList.java
 * @Date 2019��12��3��
 * @Description ����
 * @Version
 */
public class LinkedList {

    private class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return "Node [data=" + data + ", next=" + next + "]";
        }

    }

    private Node head;

    public LinkedList() {
        Node head = null;
    }

    /**
     * @return ������
     * @description ������
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
     * @param loc λ��
     * @param e   ������Ԫ��
     * @description ����Ԫ��
     */
    public void insert(int loc, int e) {
        // ���ҵ�loc - 1 λ�ã�
        Node node = new Node(e, null);
        node.data = e;
        if (loc == 0) {

            node.next = null;
            head = node;
        } else {
            Node p = head;
            for (int i = 0; i < loc - 1; i++) {
                p = p.next;
            }
            node.next = p.next;
            p.next = node;
        }
    }

    /**
     * @param loc �������е�λ��
     * @description ɾ��������ĳ���ڵ��Ԫ��
     */
    public void delete(int loc) {
        Node p = head;
        for (int i = 0; i < loc - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    /**
     * @return �Ƿ�Ϊ��
     * @description �ж������Ƿ�Ϊ����
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * @description �������
     */
    public void traversal() {
        Node p = head;
        while (p != null) { // ĳ���ڵ����һ���ڵ㲻Ϊ��
            System.out.print(p.data + "--");
            p = p.next;
        }
    }

    /**
     * @param loc �����е�λ��
     * @return data �ڵ��е�Ԫ��
     * @description ��ȡĳ��Ԫ���������е�λ��
     */
    public int getElem(int loc) {
        Node p = head;
        for (int i = 0; i < loc; i++) {
            p = p.next;
        }
        return p.data;
    }

    /**
     * @param e �ڵ��Ԫ��
     * @return loc Ԫ�ص�λ��
     * @description ��ȡĳ��λ��Ԫ���������е�λ��
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

    /**
     * @description ������ת
     */
    public void reverse() {
        Node pre = null, cur = head;
        // while ѭ��֪����ȫ������������
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // ��ת֮������ cur ָ�븳ֵ��ͷָ��
        head = pre;
    }


    /**
     * @param num ÿ��ڵ�����
     * @description ���鷴ת������
     */
    public void reverseByGroup(int num) {

        LinkedList tempList = new LinkedList();
        Node curHead = head;
        for (int i = this.size(); i > 0; i -= num) {
            LinkedList curGroup = duplicate(this, num);
            for (int y = 0; y < num; y++) {
                if (this.head.next != null) {
                    this.head = this.head.next;
                }
            }
            Node p = curHead;
            // ��λ��һ���λ��
            for (int j = 0; j < num; j++) {
                // �����������С�� k ,����Ҫ��ת
                if (p.next != null) {
                    p = p.next;
                }
            }
            // �����Ƶ���������ת
            curGroup.reverse();
            tempList.jointList(curGroup);
            curHead = p;
        }
        this.head = tempList.head;

    }

    /**
     * @param targetList ������Ŀ������
     * @description ���ӵ�ǰ�����һ��������
     */
    public void jointList(LinkedList targetList) {
        if (this.head == null) {
            this.head = targetList.head;
            return;
        }
        Node pointer = this.head;
        // �ҵ�ǰһ�������βָ��
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = targetList.head;
    }

    public String toString() {
        return "LinkedList [head=" + head + "]";
    }

    /**
     * @param oriList ԭʼ����
     * @param num     ���ƽڵ������
     * @return ��������
     * @description ����һ�������ֽڵ�
     */
    public LinkedList duplicate(LinkedList oriList, int num) {
        LinkedList duplicateList = new LinkedList();
        Node cur = oriList.head;
        int loc = 0;
        duplicateList.head = oriList.head;
        while (cur != null && loc < num) {
            duplicateList.insert(loc++, cur.data);
            cur = cur.next;
        }
        return duplicateList;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(0, 0);
        ll.insert(1, 1);
        ll.insert(2, 2);
        ll.insert(3, 3);
        ll.reverseByGroup(2);
        ll.traversal();
    }
}
