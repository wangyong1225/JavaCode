package com.wy.linkcode;


import com.wy.lintcode.Solution1;
import org.junit.Test;

import java.util.HashSet;

public class Test01 {
    @Test
    public void Test01(){
        Solution1 main = new Solution1();

        double[] arr = {2,0,1,1,1,1,0,2};
        System.out.println(main.IfIntersect(arr));
    }
}
