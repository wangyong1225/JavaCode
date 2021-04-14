package com.wy.handler;

import com.wy.serviceTools.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target; // ServiceImpl类

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //通过代理对象执行方法是，会调用这个invoke()
        System.out.println("执行了invoke()");
        String methodName = method.getName();
        System.out.println("执行的方法为："+ methodName);
        Object res = null;
        if("doSome".equals(methodName)){
            ServiceTools.myLog();
            //执行目标类的方法，通过Method类实现
            res = method.invoke(target,args); //ServiceImpl.doSome(),doOther()
            ServiceTools.myService();
        }else {
            res = method.invoke(target,args); //ServiceImpl.doSome(),doOther()
        }


        return res;
    }
}
