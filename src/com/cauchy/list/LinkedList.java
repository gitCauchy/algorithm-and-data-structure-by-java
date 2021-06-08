package com.cauchy.list;

/**
 * @author Cauchy
 * @ClassName LinkedList.java
 * @Date 2019年12月3日
 * @Description 链表
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
        // 先找到loc - 1 位置：
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

    /**
     * @description 单链表反转
     */
    public void reverse() {
        Node pre = null, cur = head;
        // while 循环知道完全遍历整个链表
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // 反转之后将最后的 cur 指针赋值给头指针
        head = pre;
    }


    /**
     * @param num 每组节点数量
     * @description 分组反转单链表
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
            // 定位下一组的位置
            for (int j = 0; j < num; j++) {
                // 如果该链表长度小于 k ,不需要反转
                if (p.next != null) {
                    p = p.next;
                }
            }
            // 将复制的链表做反转
            curGroup.reverse();
            tempList.jointList(curGroup);
            curHead = p;
        }
        this.head = tempList.head;

    }

    /**
     * @param targetList 待连接目标链表
     * @description 连接当前链表和一个新链表
     */
    public void jointList(LinkedList targetList) {
        if (this.head == null) {
            this.head = targetList.head;
            return;
        }
        Node pointer = this.head;
        // 找到前一个链表的尾指针
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = targetList.head;
    }

    public String toString() {
        return "LinkedList [head=" + head + "]";
    }

    /**
     * @param oriList 原始链表
     * @param num     复制节点的数量
     * @return 副本链表
     * @description 复制一个链表部分节点
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
