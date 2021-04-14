package com.wy.test;

import com.wy.handler.MyInvocationHandler;
import com.wy.service.Service;
import com.wy.service.impl.ServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        /*Service service = new ServiceImpl();
        service.doSome();
        System.out.println("=============================");
        service.doOther();*/
        // 使用jdk的proxy创建代理对象
        // 创建目标对象

        Service target = new ServiceImpl();
        // 创建InvocationHandler对象
        InvocationHandler handler = new MyInvocationHandler(target);
        // 使用Proxy创建代理
        Service proxy = (Service) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);

        proxy.doOther();
        System.out.println("---------------");
        proxy.doSome();

    }
}
