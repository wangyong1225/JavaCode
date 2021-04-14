package com.wy.dao;

import com.wy.domain.Student;

import java.util.List;

public interface StudentDao {
    // 查询
    List<Student> selectStudents();
    // 添加
    int insertStudent(Student student);
    // 删除
    int deleteStudent(Integer id);


}
