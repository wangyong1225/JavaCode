package com.wy;


import com.wy.sort.Solution;
import org.junit.Test;

import java.util.ArrayList;

public class TestSort {
    @Test
    public void testDeleteRe(){
        Solution solution = new Solution();
        String str = "aaabbbaccaa";

        char[] chars=solution.deleteRe(str);
        System.out.println(chars);
    }

    @Test
    public void testPermutation(){
        Solution solution = new Solution();
        String str = "abc";

        ArrayList<String> res = solution.permutation(str);
        for(String s : res){
            System.out.println(s);
        }

    }

    @Test
    public void testNumberOf1Between1AndN(){
        Solution solution = new Solution();
        System.out.println(solution.numberOf1Between1AndN(19));
    }

    @Test
    public void TestIsSmall(){
        Solution solution = new Solution();
        int a = 3;
        int b = 32;
        System.out.println(solution.isSmall(a,b));
    }

    @Test
    public void TestPrintMinNumber(){
        Solution solution = new Solution();
        int[] nums = {3,32,321};
        String res = solution.PrintMinNumber(nums);
        System.out.println(res);
    }

    @Test
    public void TestIsUglyNumber(){
        Solution solution = new Solution();

        System.out.println(solution.getUglyNumber(7));
    }
}
