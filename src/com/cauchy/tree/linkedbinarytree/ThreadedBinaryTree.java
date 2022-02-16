package com.cauchy.tree.linkedbinarytree;

/**
 *
 * @author Cauchy
 * @ClassName ThreadedBinaryTree.java
 * @Date 2019年12月12日
 * @Description 线索二叉树
 * @Version V0.1
 *
 */
public class ThreadedBinaryTree {
    /*
     * 根节点
     */
    ThreadedNode root;

    /*
     * 临时存储前驱节点
     */
    ThreadedNode preNode = null;

    public ThreadedBinaryTree() {
        root = null;
    }

    /**
     *
     * @param data
     * @param fNode
     * @param nodeType
     * @return
     * @throws Exception
     * @Description 插入节点
     */
    public ThreadedNode buildTreeNode(int data, ThreadedNode fNode, String nodeType) throws Exception {
        ThreadedNode node = new ThreadedNode(data);
        if (fNode != null) {
            if (nodeType.equals("left")) {
                fNode.lNode = node;
            } else if (nodeType.equals("right")) {
                fNode.rNode = node;
            } else {
                throw new Exception("No such type node");
            }
        }
        return node;
    }

    /**
     * @Description 先序线索二叉树
     */
    public void threadPreOrderBinaryTree() {
        threadPreOrderBinaryTree(root);
    }

    /**
     * @Description 中序线索二叉树
     */
    public void threadInOrderBinaryTree() {
        threadInOrderBinaryTree(root);
    }

    public void threadPostOrderBinaryTree() {
        threadPostOrderBinaryTree(root);
    }
    /**
     * @Description 先序遍历线索二叉树
     */
    public void threadPreOrderIterator() {
        ThreadedNode node = root;
        loop : while(node != null) {
            while(node.lNode != null && node.lType == 0) {
                System.out.println(node.data);
                node = node.lNode;
            }
            System.out.println(node.data);
            if(node.rType == 1) {
                node = node.rNode;
            }
            if(node.rNode == null) {
                System.out.println(node.data);
                break loop;
            }
        }
    }
    /**
     * @Description 中序线索遍历
     */
    public void threadInOrderIterator() {
        // 用于存储当前遍历的节点
        ThreadedNode node = root;
        while (node != null) {
            // 循环找到最开始的节点
            while (node.lType == 0) {
                node = node.lNode;
            }
            // 打印当前节点的值
            System.out.println(node.data);
            // 如果当前节点的右指针指向的是后继节点，可能后继节点还有后继节点
            while (node.rType == 1) {
                node = node.rNode;
                System.out.println(node.data);
            }
            // 替换遍历的节点
            node = node.rNode;
        }
    }

    public void threadPostOrderIterator() {

    }

    /**
     * @param x
     * @Description 删除节点
     */
    public void deleteNode(int x) {

    }

    private void threadPreOrderBinaryTree(ThreadedNode node) {
        // 处理当前节点
        if (node.lNode == null) {
            node.lNode = preNode;
            node.lType = 1;
        }
        if (preNode != null && preNode.rNode == null) {
            preNode.rNode = node;
            preNode.rType = 1;
        }
        preNode = node;
        // 处理左节点
        if (node.lNode != null && node.lType == 0) {
            threadPreOrderBinaryTree(node.lNode);
        }
        // 处理右节点
        if (node.rNode != null && node.rType == 0) {
            threadPreOrderBinaryTree(node.rNode);
        }
    }

    /**
     * @param node
     * @Description 中序线索二叉树
     */
    private void threadInOrderBinaryTree(ThreadedNode node) {
        // 处理左子树
        if (node.lNode != null) {
            threadInOrderBinaryTree(node.lNode);
        }
        // 处理前驱节点
        if (node.lNode == null) {
            // 当前节点的左指针指向前驱节点，改变左指针类型
            node.lNode = preNode;
            node.lType = 1;
        }
        // 处理前驱节点的右指针
        if (preNode != null && preNode.rNode == null) {
            // 如果前驱节点的右指针为空，指向此节点
            preNode.rNode = node;
            preNode.rType = 1;
        }
        // 每处理一个节点，这个节点就是下一个节点的的前驱节点
        preNode = node;
        // 处理右子树
        if (node.rNode != null) {
            threadInOrderBinaryTree(node.rNode);
        }
    }

    /**
     * @Description 后序线索二叉树
     */
    private void threadPostOrderBinaryTree(ThreadedNode node) {
        // 先处理左节点
        if (node.lNode != null) {
            threadPostOrderBinaryTree(node.lNode);
        }
        // 处理右节点
        if (node.rNode != null) {
            threadPostOrderBinaryTree(node.rNode);
        }
        // 处理当前节点的左指针
        if (node.lNode == null) {
            node.lNode = preNode;
            node.lType = 1;
        }
        // 当前节点前驱节点的右指针
        if (preNode != null && preNode.rNode == null) {
            preNode.rNode = node;
            preNode.rType = 1;
        }
        preNode = node;
    }

    public static void main(String[] args) throws Exception {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.root = tree.buildTreeNode(1, null, null);
        ThreadedNode n21 = tree.buildTreeNode(2, tree.root, "left");
        ThreadedNode n22 = tree.buildTreeNode(3, tree.root, "right");
        ThreadedNode n31 = tree.buildTreeNode(4, n21, "left");
        ThreadedNode n32 = tree.buildTreeNode(5, n21, "right");
        ThreadedNode n33 = tree.buildTreeNode(6, n22, "left");
        ThreadedNode n34 = tree.buildTreeNode(7, n22, "right");
        //tree.threadPreOrderBinaryTree();
        //tree.threadPreOrderIterator();

        tree.threadPostOrderBinaryTree();
        tree.threadPostOrderIterator();
    }

}
