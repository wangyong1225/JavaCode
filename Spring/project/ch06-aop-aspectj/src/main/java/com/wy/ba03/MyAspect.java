package com.wy.ba03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/**
 * @Aspect:是aspectj框架中的注解
 *   作用：表示当前是切面类
 *   切面类：用来给业务方法增加功能的类，在这个类中有切面的功能代码
 *   位置：在类定义的上面
 */
@Aspect
public class MyAspect {
    /**
     * 环绕通知方法的定义格式
     * 1、public
     * 2、必须有一个返回值，推荐使用Object
     * 3、方法名称自定义
     * 4、方法有固定参数 ProceedingJoinPoint
     */

    /**
     * @Around：环绕通知
     *   属性：Value
     *   位置：在方法定义的上面
     * 特点：
     *   1、它是功能最强的通知
     *   2、在目标方法的前后都可以增强功能
     *   3、控制目标方法是否被调用执行
     *   4、修改原来的目标方法的执行结果，影响最后的调用结果
     *
     *   环绕通知，等同于jdk中的动态代理，InvocationHandler接口
     *
     *   参数： ProceedingJoinPoint 就等同于Method
     *      作用：执行目标方法的
     *   返回值：就是目标方法的执行结果，可以被修改
     *
     *   环绕通知通常做事务，在目标方法之前开启事务，在方法目标之后提交事务
     *
     * @param pjp
     * @return
     */
    @Around(value = "execution(* com.wy.ba03.SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {


        Object[] args = pjp.getArgs();
        String name = "";
        if( args != null && args.length > 1){
            Object arg = args[0];
            name = (String) arg;
            System.out.println(name);
        }
        // 实现环绕通知的功能
        Object res = null;
        System.out.println("环绕通知：在目标方法执行前，输出时间："+new Date());
        // 1.目标方法调用
        res = pjp.proceed();
        // 2.在目标方法的后面加入功能
        System.out.println("环绕通知，在方法执行后");
        res = "可以修改";
        return res;

    }
}
