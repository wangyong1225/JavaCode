package com.wy.ba03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component(value = "myStudent")
public class Student {
    /**
     * @value：简单类型的属性赋值
     * 属性：
     * 位置：1.在属性定义的上面，无需set方法，
     */
    public Student(){
        System.out.println("student无参构造执行");
    }
    @Value(value = "${myname}")
    private String name;
    @Value(value = "25")
    private int age;
    /**
     * 引用数据类型
     *
     * 位置
     * 1）在属性定义的上面，无序set方法，推荐使用
     * 2）在set方法的上面
     *
     * 如果要使用byName方式，需要的是：
     * 1、在属性上面加入@Autowired
     * 2、在属性上面加入@Qualifier(value="bean的id")：表示使用指定名称的bean完成赋值
     *
     * required,是一个boolean类型，默认true
     * true:表示引用类型赋值失败，程序报错，并终止执行
     * false：表示引用类型如果赋值失败，程序正常执行，引用类型是null
     */

    /**
     * 引用类型
     * @Resouce：来自jdk中的注解，spring中框架提供了对这个注解的功能支持，可以使用它给引用数据类型
     * 赋值
     *
     * 默认是byName
     */
    @Autowired
    @Qualifier(value = "mySchool")
    private School school;

    public void setSchool(School school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
