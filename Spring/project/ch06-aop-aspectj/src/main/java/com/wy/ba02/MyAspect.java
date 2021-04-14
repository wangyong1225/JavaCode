package com.wy.ba02;

import com.wy.ba03.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
     * @AfertReturning:后置通知
     *   属性：1、value：切入点表达式
     *        2、returning 自定义的变量，表示目标方法的返回值
     *          自定义变量名必须和通知方法的形参名一样
     *   位置：在方法定义的上面
     *
     * 特点：
     *    1.在目标方法之后执行的
     *    2、能够获取目标方法的返回值，可以根据这个返回值做不同的处理功能
     *    3、可以修改这个返回值
     * 后置通知的执行
     *   Object res = doOther();
     *   myAfterReturning(res);
     *   System.out.println("res"+res);
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))",
            returning = "res")
    public void myAfterRet(JoinPoint jp, Object res){
        // 获取方法的完整定义
        System.out.println("执行的方法为：" + jp.getSignature());
        // Object res：是目标方法执行后的返回值，根据返回值做你的切面
        System.out.println("后置通知：在目标方法之后执行的，获取的返回值是：" + res);
        res = "wwwww";

    }

    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther2(..))",
            returning = "res")
    public void myAfterRet2(Student res){
        // Object res：是目标方法执行后的返回值，根据返回值做你的切面
        System.out.println("后置通知：在目标方法之后执行的，获取的返回值是：" + res);
        res.setAge(33);

    }
}
