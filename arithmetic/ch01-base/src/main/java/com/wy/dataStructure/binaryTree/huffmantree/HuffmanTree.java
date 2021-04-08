package com.wy.dataStructure.binaryTree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int [] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = creatHuffmanTree(arr);
        // 测试
        preOrder(root);

    }

    // 编写一个前序遍历的方法
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else {
            System.out.println("是空树， 不能遍历");
        }
    }


    public static Node creatHuffmanTree(int[] arr){
        // 第一步为了操作方便
        // 1、遍历arr数组
        // 2、将arr的每一个元素构成一个Node
        // 3、将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for(Integer value : arr) {
            nodes.add(new Node(value));
        }

        while(nodes.size() > 1){
            // 排序 从小到大
            Collections.sort(nodes);
            System.out.println("nodes = " + nodes);

            // 取出根结点权值最小的两颗二叉树
            // 1、取出权值最小的节点
            Node leftNode = nodes.get(0);
            // 2、取出次小
            Node rightNode = nodes.get(1);
            // 3、构建新树
            Node parent = new Node(leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;
            // 4、从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5、将parent加入到nodes
            nodes.add(parent);
        }
        // 返回赫夫曼树
        return nodes.get(0);

    }


}


// 为了让Node对象持续排序Collection集合排序，让Node实现Comparable接口
class Node implements Comparable<Node>{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }


}