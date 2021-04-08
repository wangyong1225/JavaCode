package com.wy;

import com.wy.dongtai.Solution;
import org.junit.Test;

public class TestDongtai {
    Solution solution = new Solution();
    @Test
    public void Test01(){
        int[] a = {2, 5, 7};
        System.out.println(solution.coinChange(a,1));

    }

    @Test
    public void Test02(){
        System.out.println(solution.uniquePaths(2,3));

    }

    @Test
    public void Test03(){
        int[] num = {3,2,1,0,5};
        System.out.println(solution.f(num));
    }

    @Test
    public void Test04(){
        int[] num = {1,3,5,2,4,6};
        System.out.println(solution.calcMonoSum(num,6));
    }

    @Test
    public void Test05(){
        int[] num = {-1,1,2,4,4,5};
        System.out.println(solution.findArrayMex(num,num.length));
    }

    @Test
    public void Yest06(){
        int[] A = {9,3,1,10};
        System.out.println(Math.abs(A[1]-A[0]));
        System.out.println(solution.findMaxDivision(A,4));
    }
}
