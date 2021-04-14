package com.wy;

import com.wy.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    @Test
    public void testDoSome2(){
        // 使用Spring容器创建的对象
        // 1、指定搭配ring配置文件的名称
        String config = "ba01/applicationContext.xml";
        // 2、创建表示Spring容器的对象，ApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student myStudent = (Student) ac.getBean("student1");
        System.out.println(myStudent);

        Date myDate = (Date)ac.getBean("myDate");
        System.out.println(myDate);

    }

    @Test
    public void Test02(){

        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("myStudent");
        System.out.println(student);
    }



}
