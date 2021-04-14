package com.wy;

import com.wy.domain.Student;
import com.wy.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void Test01(){

        String config= "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String names[] = ctx.getBeanDefinitionNames();
        for(String na:names){
            System.out.println("容器中对象的名称"+na+"|"+ctx.getBean(na));
        }
    }

    @Test
    public void Test02(){

        String config= "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentService studentService = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setName("zhangsan");
        student.setId(1007);
        int num = studentService.addStudent(student);
        // spring 和mybatis整合在一起时，事务是自动提交的，
        System.out.println("num:"+num);

    }

    @Test
    public void Test03(){

        String config= "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentService studentService = (StudentService) ctx.getBean("studentService");

        List<Student> list = studentService.queryStudent();
        // spring 和mybatis整合在一起时，事务是自动提交的，
        for(Student student:list){
            System.out.println(student);
        }

    }

}
