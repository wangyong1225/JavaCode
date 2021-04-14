package com.wy;


import com.wy.ba07.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {
    @Test
    public void Test01(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 从容器中获取目标对象
        SomeServiceImpl proxy = (SomeServiceImpl) ctx.getBean("someService");
        System.out.println(proxy.getClass().getName());
        //com.wy.ba07.SomeServiceImpl$$EnhancerBySpringCGLIB$$5a8703b8
        // 没有接口使用的是cglib动态代理
        proxy.doSome("zhangsan",13);

    }
}
