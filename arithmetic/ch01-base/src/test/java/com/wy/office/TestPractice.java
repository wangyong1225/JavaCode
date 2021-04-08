package com.wy.office;

import org.junit.Test;

public class TestPractice {

    Practice main = new Practice();
    @Test
    public void test01(){

        int[] a = {1,2,3};
        System.out.println(main.min(a));
        System.out.println(a[0]);
    }
}
