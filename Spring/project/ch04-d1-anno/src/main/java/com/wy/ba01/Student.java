package com.wy.ba01;


import org.springframework.stereotype.Component;

/**
 * @Component：创建对象的，等同于<bean>的功能
 *   属性：value 就是对象的名称，也就是bean的id值
 *         value的值是唯一的，创建的对象在整个spring容器中就一个
 *   位置：在类的上面
 *
 * @Component(value = "myStudent")等同于
 * <bean name="myStudent" class="com.wy.ba01.Student"/>
 *
 */
@Component(value = "myStudent")
public class Student {

    public Student(){
        System.out.println("student无参构造执行");
    }
    private String name;
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
