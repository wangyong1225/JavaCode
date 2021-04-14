package com.wy.ba03;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 增加功能
        System.out.println("====目标方法soSome()=====");

    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("====目标方法doOther()====");
        return "abcd";
    }

    @Override
    public Student doOther2(String name, Integer age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("====方法doFirst执行====");
        return "doFirst";
    }
}
