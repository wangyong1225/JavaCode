package com.wy.linkcode;


import com.wy.lintcode.Solution1;
import org.junit.Test;

import java.util.HashSet;

public class Test01 {
    @Test
    public void Test001(){
        Solution1 main = new Solution1();

        int[] A = {1,4,3,2,5};
        int[] B = {1,2,3,4};
        System.out.println(main.getMaxInnerProduct(A, B));
    }
}
