package com.wy.dataStructure.binaryTree;

public class ThreadedBinaryDemo {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        ThreadedBinaryDemo main = new ThreadedBinaryDemo();
        main.root = root;
        main.threadedNodes(root);
        main.threadedList();
    }

    private Node root;
    private Node pre = null;  // pre总是保留前一个节点
    public void threadedList() {
        Node temp = root;
        while (temp != null){
            while (temp.leftType == 0){
                temp = temp.left;
            }
            System.out.println(temp.val);
            while (temp.rightType == 1){
                temp = temp.right;
                System.out.println(temp.val);
            }
            temp = temp.right;

        }
    }
    /**
     * 线索化二叉树
     * @param node
     */
    public void threadedNodes(Node node){

        if(node == null){
            return;
        }
        // 先线索化左子树
        threadedNodes(node.left);
        // 线索化当前节点
        if(node.left == null){
            node.left = pre;
            node.leftType = 1;
        }
        // 后继节点
        if(pre != null && pre.right == null){
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
        // 线索化右子树
        threadedNodes(node.right);
    }

}


