package com.wy.ba04;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 增加功能
        System.out.println("====目标方法soSome()=====");

    }

    @Override
    public void doSecond() {
        System.out.println("doSecond");
        int a = 0;
        int b = 1/a;
    }
}
