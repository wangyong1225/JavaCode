package com.wy.ba06;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 增加功能
        System.out.println("====目标方法soSome()=====");

    }

    @Override
    public void doThird() {
        System.out.println("doThird");
    }
}
