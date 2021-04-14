package com.wy;

import com.wy.service.SomeService;
import com.wy.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void testDoSome(){
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    /**
     * spring默认创建对象的时间：在创建Spring的容器时，会创建配置文件中的所有的对象
     * 默认调的是无参的构造方法
     */
    @Test
    public void testDoSome2(){
        // 使用Spring容器创建的对象
        // 1、指定搭配ring配置文件的名称
        String config = "beans.xml";
        // 2、创建表示Spring容器的对象，ApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 3、从容器中获取某个对象，调用对象的方法
        // getBean（"配置文件中的bean的id值"）
        SomeService service = (SomeService)ac.getBean("someService");

        // 使用Spring创建好的对象
        service.doSome();

    }

    /**
     * 获取Spring容器中java对象的信息
     *
     */
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 使用Spring提供的方法，获取容器中定义的东西的数量
        int num = ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象的数量：" + num);
        // 每个对象的名称
        String name[] = ac.getBeanDefinitionNames();
        for (int i = 0; i<name.length; i++){
            System.out.println(name[i]);
        }
    }

    // 获取一个非自定义的对象
    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 使用getBean();
        Date my = (Date) ac.getBean("mydate");
        System.out.println("Date"+my);
    }




}
