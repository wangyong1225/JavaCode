package com.wy;

import com.wy.dao.StudentDao;

import com.wy.domain.Student;
import com.wy.utils.MyBatisUtils;
import com.wy.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void testSelectStudentById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int id = 1002;

        Student student = dao.selectStudentById(id);
        System.out.println(student);

    }
    @Test
    public void testSelectMultiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        int age = 20;
        String name = "张三";
        List<Student> students = dao.selectMultiParam(name,age);
        for(Student stu:students){
            System.out.println(stu);
        }
    }

    @Test
    public void testupdateStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        int age=20;
        int id=1001;
        dao.updateStudent(id,age);
        sqlSession.commit();
    }

    @Test
    public void testSelectMultiMyParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueryParam queryParam = new QueryParam();
        queryParam.setParamName("张三");
        queryParam.setParamAge(22);
        dao.selectMultiMyParam(queryParam);
        sqlSession.commit();
    }

    @Test
    public void testSelectMultiStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("李四");
        student.setId(1005);
        dao.selectMultiStudent(student);
        sqlSession.commit();
    }

    @Test
    public void testCountStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);



        int num = dao.countStudent();
        System.out.println("个数为：" + num);
        sqlSession.commit();

        sqlSession.close();
    }


    @Test
    public void testSelectMaoBiId(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int id = 1001;
        Map res = dao.selectMaoBiId(id);
        System.out.println(res);


        sqlSession.close();
    }


    @Test
    public void testSelectResultMapById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List res =  dao.selectResultMapById();
        System.out.println(res);
        sqlSession.close();
    }





    @Test
    public void testSelectDiffStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List res =  dao.selectDiffStudent();
        System.out.println(res);
        sqlSession.close();
    }


    @Test
    public void testSelectLike(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "李";

        List res =  dao.selectLike(name);
        System.out.println(res);
        sqlSession.close();
    }

    @Test
    public void test(){
        boolean res = false;
    }



}
