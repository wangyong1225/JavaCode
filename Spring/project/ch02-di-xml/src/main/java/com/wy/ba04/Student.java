package com.wy.ba04;

public class Student {
    private String name;
    private int age;
    private School school;

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
