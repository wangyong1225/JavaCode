package com.wy.labyrinth.domain;

import java.util.Arrays;

public class Node {
    public int[] val;
    public Node next = null;

    public Node(int[] val){
        this.val = val;
    }
    public Node(int a, int b, int c){
        int[] num = {a, b, c};
        val = num;
    }

    public int length(){
        if(this.next == null){
            return 1;
        }
        Node root = this;
        int res = 1;
        while (root.next!=null){
            root = root.next;
            res++;
        }
        return res;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + Arrays.toString(val) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Arrays.equals(val, node.val);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(val);
    }
}
