package com.wy.dao;

import com.wy.domain.Student;
import com.wy.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> selectIfStudent(Student student);

    List<Student> selectWhereStudent(Student student);

    List<Student> selectForeachStudent(List stuId);

    List<Student> selectForeachStudentTwo(List<Student> stuId);

    List<Student> selectAll();






}
