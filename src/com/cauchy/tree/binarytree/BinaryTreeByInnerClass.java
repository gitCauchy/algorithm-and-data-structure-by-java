package com.cauchy.tree.binarytree;

/**
 * 二叉树内部类实现
 *
 * @author Cauchy
 * @date 2022/02/17 17:03
 **/
public class BinaryTreeByInnerClass {

    public class TreeNode {
        /*
         * 左子节点
         */
        TreeNode lNode;
        /*
         * 右子节点
         */
        TreeNode rNode;
        /*
         * 值
         */
        int value;

        /**
         * 先序遍历
         */
        void preOrderTraversal() {
            System.out.print(this.value + "-");
            if (lNode != null) {
                lNode.preOrderTraversal();
            }
            if (rNode != null) {
                rNode.preOrderTraversal();
            }
        }

        /**
         * 中序遍历
         */
        private void inOrderTraversal() {
            if (lNode != null) {
                lNode.inOrderTraversal();
            }
            System.out.print(this.value + "-");
            if (rNode != null) {
                rNode.inOrderTraversal();
            }
        }

        /**
         * 后序遍历
         */
        private void postOrderTraversal() {
            if (lNode != null) {
                lNode.postOrderTraversal();
            }
            if (rNode != null) {
                rNode.postOrderTraversal();
            }
            System.out.print(this.value + "-");
        }

        /**
         * 先序查找
         *
         * @param x 待查找值
         * @return 找到的节点
         */
        private TreeNode preOrderSearch(int x) {
            TreeNode target = null;
            if (this.value == x) {
                return this;
            } else {
                if (lNode != null) {
                    target = lNode.preOrderSearch(x);
                }
                if (target != null) {
                    return target;
                }
                if (rNode != null) {
                    target = rNode.preOrderSearch(x);
                }
                if (target != null) {
                    return target;
                }
            }
            return target;
        }

        /**
         * 中序查找
         *
         * @param x 待查找值
         * @return 找到的节点
         */
        private TreeNode inOrderSearch(int x) {
            TreeNode target = null;
            if (lNode != null) {
                target = lNode.inOrderSearch(x);
            }
            if (target != null) {
                return target;
            }
            if (this.value == x) {
                target = this;
                return target;
            } else {
                if (rNode != null) {
                    target = rNode.inOrderSearch(x);
                }
            }
            return target;
        }

        /**
         * 后序查找
         *
         * @param x 待查找值
         * @return 找到的节点
         */
        private TreeNode postOrderSearch(int x) {
            TreeNode target = null;
            if (lNode != null) {
                target = lNode.postOrderSearch(x);
            }
            if (target == null) {
                if (rNode != null) {
                    target = rNode.postOrderSearch(x);
                }
                if (target == null) {
                    if (this.value == x) {
                        return this;
                    }
                }
            }
            return target;
        }

        // 删除一棵子树
        private void delete(int x) {
            TreeNode parent = this;
            if (parent.lNode != null && parent.lNode.value == x) {
                parent.lNode = null;
            } else if (parent.rNode != null && parent.rNode.value == x) {
                parent.rNode = null;
            } else {
                parent = lNode;
                if (parent != null) {
                    parent.delete(x);
                }
                parent = rNode;
                if (parent != null) {
                    parent.delete(x);
                }
            }
        }

        private TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode [value=" + value + "]";
        }
    }

    /**
     * 左子节点
     */
    private static final String LEFTCHILDNODE = "l";
    /**
     * 右子节点
     */
    private static final String RIGHTCHILDNODE = "r";

    private BinaryTreeByInnerClass.TreeNode root;

    /**
     * 创建一颗空树
     */
    public BinaryTreeByInnerClass() {
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
     * 树的先序遍历
     */
    public void preOrderTraversal() {
        System.out.println("--PRE ORDER TRAVERSAL--");
        root.preOrderTraversal();
        System.out.println();
    }

    /**
     * 树的中序遍历
     */
    public void inOrderTraversal() {
        System.out.println("--IN ORDER TRAVERSAL--");
        root.inOrderTraversal();
        System.out.println();
    }

    /**
     * 树的后序遍历
     */
    public void postOrderTraversal() {
        System.out.println("--POST ORDER TRAVERSAL--");
        root.postOrderTraversal();
        System.out.println();
    }

    /**
     * 先序查找
     *
     * @param x 待查找的值
     * @return 找到的节点
     */
    public TreeNode preOrderSearch(int x) {
        return root.preOrderSearch(x);
    }

    /**
     * 中序查找
     *
     * @param x 待查找的值
     * @return 找到的节点
     */
    public TreeNode inOrderSearch(int x) {
        return root.inOrderSearch(x);
    }

    /**
     * 后序查找
     *
     * @param x 待查找的值
     * @return 找到的节点
     */
    public TreeNode postOrderSearch(int x) {
        return root.postOrderSearch(x);
    }

    /**
     * 删除节点
     *
     * @param x 待删除的值
     */
    public void deleteNode(int x) {
        root.delete(x);
    }
}
