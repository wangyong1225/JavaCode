package com.wy.ba02;


import org.springframework.beans.factory.annotation.Value;
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
    @Value(value = "张三")
    private String name;
    @Value(value = "20")
    private int age;

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
                '}';
    }
}
