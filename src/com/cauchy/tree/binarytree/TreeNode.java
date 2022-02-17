package com.cauchy.tree.binarytree;

/**
 * 二叉树节点
 *
 * @author Cauchy
 * @date 2022/02/17 16:33
 **/
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
     * 先序遍历
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
     * 中序遍历
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
     * 后序遍历
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
     * 先序查找
     *
     * @param x 待查找的值
     * @return 查到的节点
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
     * 中序查找
     *
     * @param x 待查找的值
     * @return 查到的节点
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
     *
     * @param x 待查找的值
     * @return 查到的节点
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
     * 删除节点
     *
     * @param x 待删除节点的值
     */
    void delete(int x) {
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

    TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode [ value=" + data + "]";
    }


}