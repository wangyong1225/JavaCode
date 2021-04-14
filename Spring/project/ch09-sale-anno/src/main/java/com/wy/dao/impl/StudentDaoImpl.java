package com.wy.dao.impl;

import com.wy.dao.StudentDao;
import com.wy.domain.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    // 引用类型
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    // 使用set注入，赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int insertStudent(Student student) {
        int num = studentDao.insertStudent(student);
        return num;
    }

    @Override
    public List<Student> queryStudent() {
        List<Student> students = studentDao.queryStudent();
        return students;
    }
}
