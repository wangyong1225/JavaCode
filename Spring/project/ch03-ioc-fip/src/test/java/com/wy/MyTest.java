package com.wy;


import com.wy.domain.Student;
import com.wy.service.Service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    @Test
    public void testDoSome2(){

        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Service service = (Service) ac.getBean("userService");
        Student student = new Student();
        student.setName("张三");
        student.setAge(20);
        service.addService(student);





    }





}
