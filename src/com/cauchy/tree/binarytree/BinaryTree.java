package com.cauchy.tree.binarytree;

/**
 * 二叉树
 *
 * @author Cauchy
 * @date 2022/02/17 16:42
 **/
public class BinaryTree {
    /**
     * 左子节点
     */
    private static final String LEFTCHILDNODE = "l";
    /**
     * 右子节点
     */
    private static final String RIGHTCHILDNODE = "r";
    /**
     * 根节点
     */
    private TreeNode root;

    private BinaryTree() {
        root = null;
    }

    /**
     * 创建节点
     *
     * @param data     数据
     * @param pNode    父节点
     * @param nodeType 节点类型
     * @return 创建的节点
     * @throws Exception 节点类型异常
     */
    private TreeNode buildTreeNode(int data, TreeNode pNode, String nodeType) throws Exception {
        TreeNode node = new TreeNode(data);
        if (pNode != null) {
            if (LEFTCHILDNODE.equals(nodeType)) {
                pNode.lNode = node;
            } else if (RIGHTCHILDNODE.equals(nodeType)) {
                pNode.rNode = node;
            } else {
                throw new Exception("No such type node");
            }
        }
        return node;
    }

    /**
     * 先序遍历二叉树
     */
    private void preOrderTraversal() {
        System.out.println("--PRE ORDER TRAVERSAL--");
        root.preOrderTraversal();
        System.out.println();
    }

    /**
     * 中序遍历二叉树
     */
    private void inOrderTraversal() {
        System.out.println("--IN ORDER TRAVERSAL--");
        root.inOrderTraversal();
        System.out.println();
    }

    /**
     * 后序遍历二叉树
     */
    private void postOrderTraversal() {
        System.out.println("--POST ORDER TRAVERSAL--");
        root.postOrderTraversal();
        System.out.println("");
    }

    /**
     * 先序查找
     *
     * @param x 待查找值
     * @return 查找结果
     */
    public TreeNode preOrderSearch(int x) {
        return root.preOrderSearch(x);
    }

    /**
     * 中序查找
     *
     * @param x 待查找值
     * @return 查找结果
     */
    public TreeNode inOrderSearch(int x) {
        return root.inOrderSearch(x);
    }

    /**
     * 后序查找
     *
     * @param x 待查找值
     * @return 查找结果
     */
    private TreeNode postOrderSearch(int x) {
        return root.postOrderSearch(x);
    }

    /**
     * 删除节点
     *
     * @param x 待删除节点
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
        TreeNode n21 = tree.buildTreeNode(2, tree.root, "l");
        TreeNode n22 = tree.buildTreeNode(3, tree.root, "r");
        TreeNode n31 = tree.buildTreeNode(4, n21, "l");
        TreeNode n32 = tree.buildTreeNode(5, n21, "r");
        TreeNode n33 = tree.buildTreeNode(6, n22, "l");
        TreeNode n34 = tree.buildTreeNode(7, n22, "r");
        tree.preOrderTraversal();
        tree.inOrderTraversal();
        tree.postOrderTraversal();
        TreeNode five = tree.postOrderSearch(5);
        System.out.println(five);

    }
}
