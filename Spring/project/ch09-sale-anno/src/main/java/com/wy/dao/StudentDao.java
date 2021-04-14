package com.wy.dao;

import com.wy.domain.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);
    List<Student> queryStudent();
}
