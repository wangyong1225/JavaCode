package com.wy.linkcode;

import com.wy.lintcode.Solution1;
import com.wy.treenode.TreeNode;
import org.junit.Test;

import java.util.List;

public class Test20 {
    Solution1 solution = new Solution1();
    @Test
    public void test02(){
        System.out.println(solution.trailingZeros(105));

    }

    @Test
    public void test03(){
        System.out.println(solution.digitCounts(1,2345));
    }

    @Test
    public void test04(){
        System.out.println(solution.nthUglyNumber(9));
    }

    @Test
    public void test07(){
        String str = "1,2,3,#,#,4,5";
        TreeNode root = solution.deserialize(str);
        System.out.println(root.val);
    }


    @Test
    public void test11(){
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(1);
        root.right = new TreeNode(40);
        root.right.left = new TreeNode(35);
        List<Integer> list= solution.searchRange(root,17,37);
        for(Integer res:list){
            System.out.println(res);
        }

        /*List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(0,2);
        for(Integer res:test){
            System.out.println(res);
        }*/


    }

    @Test
    public void test12(){
        System.out.println(solution.strStr("abc","bc"));
    }

    @Test
    public void test13(){


        double n = 2.99999;
        System.out.println((int)n );
    }


}
