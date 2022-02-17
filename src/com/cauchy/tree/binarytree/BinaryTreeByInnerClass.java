package com.cauchy.tree.binarytree;

/**
 * @author Cauchy
 * @ClassName BinaryTree.java
 * @Date 2019年12月5日
 * @Description 二叉树
 * @Version V0.1
 */
public class BinaryTreeByInnerClass {

    public class TreeNode {
        /**
         * 左子节点
         */
        TreeNode lNode;
        /**
         * 右子节点
         */
        TreeNode rNode;
        /**
         * 值
         */
        int value;

        /**
         * @Description 先序遍历
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
         * @Description 中序遍历
         */
        void inOrderTraversal() {
            if (lNode != null) {
                lNode.inOrderTraversal();
            }
            System.out.print(this.value + "-");
            if (rNode != null) {
                rNode.inOrderTraversal();
            }
        }

        /**
         * @Description 后序遍历
         */
        void postOrderTraversal() {
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
         * @param x
         * @return
         */
        public TreeNode preOrderSearch(int x) {
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
         * @param x
         * @return
         */
        public TreeNode inOrderSearch(int x) {
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
         * @param x
         * @return
         * @Description 后序查找
         */
        public TreeNode postOrderSearch(int x) {
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
        public void delete(int x) {
            TreeNode parent = this;
            if (parent.lNode != null && parent.lNode.value == x) {
                parent.lNode = null;
                return;
            } else if (parent.rNode != null && parent.rNode.value == x) {
                parent.rNode = null;
                return;
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

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode [value=" + value + "]";
        }
    }

    BinaryTreeByInnerClass.TreeNode root;

    /**
     * @description 创建一颗空树
     */
    public BinaryTreeByInnerClass() {
        root = null;
    }

    /**
     * @param data
     * @param fNode
     * @param nodeType
     * @return 新建立的节点
     * @throws Exception
     */
    public TreeNode setTreeNode(int data, TreeNode fNode, String nodeType) throws Exception {

        TreeNode node = new TreeNode(data);
        if (fNode != null) {
            if (nodeType.equals("left")) {
                fNode.lNode = node;
            } else if (nodeType.equals("right")) {
                fNode.rNode = node;
            } else {
                throw new Exception("No such Type Node");
            }
        }

        return node;
    }

    /**
     * @description 树的先序遍历
     */
    public void preOrderTraversal() {
        System.out.println("--PRE ORDER TRAVERSAL--");
        root.preOrderTraversal();
        System.out.println();
    }

    /**
     * @description 树的中序遍历
     */
    public void inOrderTraversal() {
        System.out.println("--IN ORDER TRAVERSAL--");
        root.inOrderTraversal();
        System.out.println();
    }

    /**
     * @description 树的后序遍历
     */
    public void postOrderTraversal() {
        System.out.println("--POST ORDER TRAVERSAL--");
        root.postOrderTraversal();
        System.out.println();
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
     * @param x
     * @Description 删除节点
     */
    public void deleteNode(int x) {
        root.delete(x);
    }
}
