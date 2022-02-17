package com.cauchy.tree.binarytree;

/**
 * @author Cauchy
 * @ClassName TreeNode.java
 * @Date 2019年12月11日
 * @Description 二叉树节点
 * @Version V0.1
 */
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
    int data;

    /**
     * @Description 先序遍历
     */
    void preOrderTraversal() {
        System.out.print(this.data + "-");
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
        System.out.print(this.data + "-");
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
        System.out.print(this.data + "-");
    }

    /**
     * @param x
     * @return Node
     * @Description 先序查找
     */
    TreeNode preOrderSearch(int x) {
        TreeNode target = null;
        if (this.data == x) {
            return this;
        } else {
            if (lNode != null) {
                target = lNode.preOrderSearch(x);
                if (target != null) {
                    return target;
                }
            }
            if (rNode != null) {
                target = rNode.preOrderSearch(x);
                if (target != null) {
                    return target;
                }
            }

        }
        return target;
    }

    /**
     * @param x
     * @return
     * @Description 中序查找
     */
    TreeNode inOrderSearch(int x) {
        TreeNode target = null;
        if (lNode != null) {
            target = lNode.inOrderSearch(x);
            if (target != null) {
                return target;
            }
        }

        if (this.data == x) {
            target = this;
            return target;
        }
        if (rNode != null) {
            target = rNode.inOrderSearch(x);
            if (target != null) {
                return target;
            }
        }
        return target;
    }

    /**
     * 后序查找
     * @param x
     * @return
     */
     TreeNode postOrderSearch(int x) {
        TreeNode target = null;
        if (lNode != null) {
            target = lNode.postOrderSearch(x);
            if (target != null) {
                return target;
            }
        }

        if (rNode != null) {
            target = rNode.postOrderSearch(x);
            if (target != null) {
                return target;
            }
        }
        if (this.data == x) {
            return this;
        }

        return target;
    }

    /**
     * @param x
     * @Description 删除节点
     */
    public void delete(int x) {
        TreeNode cur = this;
        // 如果左节点不为空且恰好为要查找删除的节点，就将节点删除
        if (cur.lNode != null && cur.lNode.data == x) {
            cur.lNode = null;
            // 如果右节点不为空且恰好为要查找删除的节点，就将节点删除
        } else if (cur.rNode != null && rNode.data == x) {
            cur.rNode = null;
        } else {
            cur = cur.lNode;
            if (cur != null) {
                cur.delete(x);
            }
            cur = cur.rNode;
            if (cur != null) {
                cur.delete(x);
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode [ value=" + data + "]";
    }


}
