package com.cauchy.tree.binarytree;

/**
 * @author Cauchy
 * @ClassName BinaryTree.java
 * @Date 2019年12月11日
 * @Description 二叉树实现
 * @Version V0.1
 */
public class BinaryTree {
    /**
     * 根节点
     */
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    /**
     * @param data     数据
     * @param pNode    父节点
     * @param nodeType 节点类型
     * @return
     * @throws Exception
     * @Description 插入节点
     */
    public TreeNode buildTreeNode(int data, TreeNode pNode, String nodeType) throws Exception {
        TreeNode node = new TreeNode(data);
        if (pNode != null) {
            if (nodeType.equals("left")) {
                pNode.lNode = node;
            } else if (nodeType.equals("right")) {
                pNode.rNode = node;
            } else {
                throw new Exception("No such type node");
            }
        }
        return node;
    }

    /**
     * @Description 先序遍历二叉树
     */
    public void preOrderTraversal() {
        System.out.println("--PRE ORDER TRAVERSAL--");
        root.preOrderTraversal();
        System.out.println();
    }

    /**
     * @Description 中序遍历二叉树
     */
    public void inOrderTraversal() {
        System.out.println("--IN ORDER TRAVERSAL--");
        root.inOrderTraversal();
        System.out.println();
    }

    /**
     * @Description 后序遍历二叉树
     */
    public void postOrderTraversal() {
        System.out.println("--POST ORDER TRAVERSAL--");
        root.postOrderTraversal();
        System.out.println("");
    }

    /**
     * @param x
     * @return
     * @Description 先序查找
     */
    public TreeNode preOrderSearch(int x) {
        return root.preOrderSearch(x);
    }

    /**
     * @param x
     * @return
     * @Description 中序查找
     */
    public TreeNode inOrderSearch(int x) {
        return root.inOrderSearch(x);
    }

    /**
     * @param x
     * @return
     * @Description 后序查找
     */
    public TreeNode postOrderSearch(int x) {
        return root.postOrderSearch(x);
    }

    /**
     * 删除节点
     *
     * @param x
     */
    public void deleteNode(int x) {
        if (root.data == x) {
            root = null;
        } else {
            root.delete(x);
        }
    }

    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.buildTreeNode(1, null, null);
        TreeNode n21 = tree.buildTreeNode(2, tree.root, "left");
        TreeNode n22 = tree.buildTreeNode(3, tree.root, "right");
        TreeNode n31 = tree.buildTreeNode(4, n21, "left");
        TreeNode n32 = tree.buildTreeNode(5, n21, "right");
        TreeNode n33 = tree.buildTreeNode(6, n22, "left");
        TreeNode n34 = tree.buildTreeNode(7, n22, "right");
        tree.preOrderTraversal();
        tree.inOrderTraversal();
        tree.postOrderTraversal();
        TreeNode five = tree.postOrderSearch(5);
        System.out.println(five);

    }
}
