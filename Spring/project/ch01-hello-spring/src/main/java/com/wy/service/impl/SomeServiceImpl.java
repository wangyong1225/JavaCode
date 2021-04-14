package com.wy.service.impl;

import com.wy.service.SomeService;

public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl(){
        System.out.println("SomeServiceImpl无参构造方法启动");
    }
    @Override
    public void doSome() {
        System.out.println("执行了SomeService中的doSome()方法");
    }
}
