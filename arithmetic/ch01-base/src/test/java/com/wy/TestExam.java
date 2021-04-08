package com.wy;

import com.wy.exam.Solution;
import org.junit.Test;

import java.util.Scanner;

public class TestExam {
    Solution solution = new Solution();
    @Test
    public void Test01(){
        Solution solution = new Solution();
        int a = 3;
        int b = 2;
        int n = 8;
        System.out.println(solution.solve(a,b,n));
        System.out.println('a' - 'b');
    }

    @Test
    public void Test02(){
        Solution solution = new Solution();
        String s = "ABCAB";
        System.out.println(solution.solve(s));
    }

    @Test
    public void Test03(){
        System.out.println(solution.mathexp(55));
        System.out.println(solution.Sum(4));
        int[] a = {4,1,2,3};

    }


    @Test
    public void Test04(){

        Scanner sn = new Scanner(System.in);
        String str = sn.next();
        System.out.println(str);
    }

    @Test
    public void Test05(){

    }
}
