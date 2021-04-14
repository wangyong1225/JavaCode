package com.wy.dao;

import com.wy.domain.MyStudent;
import com.wy.domain.Student;
import com.wy.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /**
     * 一个简单类型的参数
     * 简单类型：mybatis把java的基本数据类型和String都叫简单类型
     *
     * 在mapper问价获取简单类型的一个参数，使用#{任意字符}
     */

    public Student selectStudentById(@Param("id") Integer id);

    /**
     * 多个参数：命名参数，
     */

    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") int age);

    List<Student> selectMultiMyParam(QueryParam queryParam);

    List<Student> selectMultiStudent(Student student);


    void updateStudent(@Param("myid") int id,
                       @Param("myage") int age);

    int countStudent();

    Map<Object, Object> selectMaoBiId(int id);

    /**
     * 使用resultMap来定义映射关系
     */

    List<Student> selectResultMapById();

    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffStudent();

    List<Student> selectLike(@Param("name") String name);






}
