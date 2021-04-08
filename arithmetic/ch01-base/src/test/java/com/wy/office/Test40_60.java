package com.wy.office;

import com.wy.lick.domain.ListNode;
import com.wy.treenode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test40_60 {

    Solution40_60 solution = new Solution40_60();
    @Test
    public void Test01(){
        String s = "ab ab";
        System.out.println(solution.ReverseSentence(s));
        System.out.println(s.length()+"***"+solution.ReverseSentence(s).length());
    }

    @Test
    public void Test02(){
        System.out.println(solution.LastRemaining_Solution(6,3));
    }


    @Test
    public void Test03(){
        System.out.println(solution.add(5,7));
        System.out.println(5&7);
    }

    @Test
    public void Test04(){
        char c = '2';

    }

    @Test
    public void Test05(){
        ListNode p1 = new ListNode(1);
        p1.next=new ListNode(2);
        p1.next.next=new ListNode(3);
        p1.next.next.next=new ListNode(3);
        p1.next.next.next.next=new ListNode(4);
        p1.next.next.next.next.next=new ListNode(4);
        p1.next.next.next.next.next.next=new ListNode(5);

    }

    @Test
    public void Test06(){
        ArrayList<Integer> res = new ArrayList<>();
        res.add(null);
        System.out.println(res.size());
    }

    @Test
    public void Test07(){
       int[] s = {1,2,3};
       int j = 1;
       System.out.println(s[++j]);
    }

    @Test
    public void Test08(){

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        String str = solution.Serialize(p);
        String[] strings = str.split(",");
        for(String s:strings){
            System.out.println(s);
        }
        System.out.println(solution.Deserialize(str));
    }

    @Test
    public void Test09(){

        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);

        num.add(0,3);
        for(Integer res:num){
            System.out.println(res);
        }

    }

    @Test
    public void Test10(){

        String str = "ABC";
        System.out.println(str.substring(0,3));

    }

    @Test
    public void Test11(){


        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        System.out.println(solution.isPopPush(push,pop));


    }

    @Test
    public void Test12(){



    }


}
