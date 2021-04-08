package com.wy.dataStructure.binaryTree.AVL;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10, 11, 7, 6, 8, 9, 1, 2, 3, 4, 5, 12, 13, 14, 15, 16};
        // 创建一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        // 添加结点
        for(int i : arr){
            avlTree.add(new Node(i));
        }
        avlTree.infixSort();
        System.out.println("在没有平衡处理前");
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("树的左子树高度：" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度：" + avlTree.getRoot().rightHeight());


    }

}

class AVLTree{
    private Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else {
            root.add(node);
        }
    }
    public void infixSort(){
        if(root == null){
            return;
        }
        root.infixList();
    }

    public Node getRoot() {
        return root;
    }

    public void delete(int val){
        if(root.val == val){
            delete();
        }else {
            root.delete(val);
        }
    }
    private void delete(){
        if(root.left == null && root.right == null){
            root = null;
        }else {
            if(root.right != null && root.left != null){
                root.val = root.delRightTreeMin(root.right);
            }else {
                if(root.left == null){
                    root = root.right;
                }else {
                    root = root.left;
                }
            }
        }
    }
}

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }

    /**
     * 返回当前结点的高度
     */
    public int height(){
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        if( left == null){
            return 0;
        }
        return left.height();
    }

    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    /**
     * 左旋转
     */
    public void leftRotate(){
        Node newNode = new Node(val);
        newNode.left = left;
        newNode.right = right.left;
        val = right.val;
        right = right.right;
        left = newNode;
    }

    /**
     * 右旋转
     */
    public void rightRotate(){
        Node newNode = new Node(val);
        newNode.right = right;
        newNode.left = left.right;
        val = left.val;
        left = left.left;
        right = newNode;
    }

    /**
     * 添加结点
     * 递归的形式添加结点，满足二叉排序树的要求
     */
    public void add(Node node){
        if(node == null){
            return;
        }
        // 判断传入的结点的值，和当前子树的根结点的值的关系
        if(node.val < this.val){
            if(this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
        // 判断左右子树的高度，如果左子树多2则右旋，反之左旋
        if(leftHeight() - rightHeight() > 1){
            if(left.leftHeight() < left.rightHeight()){
                left.leftRotate();
            }
            rightRotate();
            return;
        }
        if(rightHeight() - leftHeight() > 1){
            if(right.leftHeight() > right.rightHeight()){
                left.rightRotate();
            }
            leftRotate();
        }


    }

    // 中序遍历
    public void infixList(){
        if(this.left !=null)
            this.left.infixList();
        System.out.println(this.val);
        if(this.right != null)
            this.right.infixList();
    }

    // 删除节点
    /**
     * findDelete:找到要要删除的结点，将该结点存放到targetNode中，他的父节点存放在parent中
     */
    public static Node parent;
    public static Node targetNode;
    public void findDelete(int val){
        if(val < this.val){
            if(this.left != null){
                if(val == this.left.val){
                    parent = this;
                    targetNode = this.left;
                    return;
                }else {
                    this.left.findDelete(val);
                }
            }
        }else {
            if(this.right != null){
                if(val == this.right.val){
                    parent = this;
                    targetNode = this.right;
                    return;
                }else {
                    this.right.findDelete(val);
                }
            }
        }
    }

    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delete(target.val);
        return target.val;
    }

    public void delete(int val){
        findDelete(val);
        if(targetNode.left == null && targetNode.right == null){
            if(parent.left == targetNode){
                parent.left = null;
            }else {
                parent.right = null;
            }
            return;
        }
        if(targetNode.left != null && targetNode.right != null){
            targetNode.val = delRightTreeMin(targetNode.right);
        }
        if(targetNode.left != null){
            if(parent.left == targetNode){
                parent.left = targetNode.left;
            }else {
                parent.right = targetNode.left;
            }
        }else {
            if(parent.left == targetNode){
                parent.left = targetNode.right;
            }else {
                parent.right = targetNode.right;
            }
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

}