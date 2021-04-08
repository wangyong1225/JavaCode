package com.wy;

import com.wy.labyrinth.domain.Node;
import org.junit.Test;

public class TestLabyrinth {
    @Test
    public void Test01(){
        int[] num = {1,2,3};
        Node node = new Node(num);
        Node node1 = new Node(1,2,3);
        node.next = node1;
        System.out.println("node的长度为：" + node.length());
        System.out.println(node.equals(node1));

        int step = 0;


    }
}
