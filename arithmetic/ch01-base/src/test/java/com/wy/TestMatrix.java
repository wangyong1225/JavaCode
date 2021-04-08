package com.wy;


import com.wy.Matrix.Solution;
import org.junit.Test;

public class TestMatrix {

    @Test
    public void Test01(){
        int num = (int)Math.ceil(4/2.0);
        System.out.println(num);
    }



    @Test
    public void TestMax(){
        Solution solution = new Solution();
        int[] nums = {1,1,0};
        int[] res = solution.max(nums);
        System.out.println(solution.moreThanHalfNum(nums));

    }

    @Test
    public void TestfindGreatestSumOfSubArray(){
        Solution solution = new Solution();
        int[] num = {-1,-2,-3,-10,-4,-7,-2,-5};

        System.out.println(solution.findGreatestSumOfSubArray(num));

    }



}
