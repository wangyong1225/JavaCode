package com.wy.ba03;

public class Student {
    private String name;
    private int age;
    private School school;

    public Student(){}

    public Student(String name, int age, School school){
        this.age=age;
        this.name=name;
        this.school=school;
    }

    public void setSchool(School school) {
        System.out.println("setSchool---" + school);
        this.school = school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email){
        System.out.println("setEmail:  "+email);
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
