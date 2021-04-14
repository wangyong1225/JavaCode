package com.wy;

import com.github.pagehelper.PageHelper;
import com.wy.dao.StudentDao;

import com.wy.domain.Student;
import com.wy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void testSelectIfStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("李四");
        student.setAge(14);

        List<Student> studentList = dao.selectIfStudent(student);
        for (Student stu:studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectWhereStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("李四");
        student.setAge(14);

        List<Student> studentList = dao.selectWhereStudent(student);
        for (Student stu:studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectForeachStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List list = new ArrayList();
        list.add(1001);
        list.add(1002);

        List<Student> studentList = dao.selectForeachStudent(list);
        for (Student stu:studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectForeachStudentTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> list = new ArrayList();
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setId(1001);
        student2.setId(1002);
        list.add(student1);
        list.add(student2);

        List<Student> studentList = dao.selectForeachStudentTwo(list);
        for (Student stu:studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        PageHelper.startPage(1,3);



        List<Student> studentList = dao.selectAll();
        for (Student stu:studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }



}
