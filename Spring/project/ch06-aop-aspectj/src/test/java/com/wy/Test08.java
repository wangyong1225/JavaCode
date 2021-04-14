package com.wy;

import com.wy.ba08.SomeService;
import com.wy.ba08.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {
    @Test
    public void Test01(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 从容器中获取目标对象
        SomeService proxy = (SomeService) ctx.getBean("someService");
        System.out.println(proxy.getClass().getName()); // com.sun.proxy.$Proxy14
        proxy.doThird();

    }
}
