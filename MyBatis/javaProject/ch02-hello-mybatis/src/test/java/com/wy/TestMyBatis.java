package com.wy;

import com.wy.dao.StudentDao;

import com.wy.domain.Student;
import com.wy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelectStudents(){
        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getMapper（dao接口）
         * getMapper能获取dao接口对于的实现类对象
         */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // 调用dao的方法，执行数据库的操作
        List<Student> students = dao.selectStudents();
        for(Student stu:students){
            System.out.println(stu);
        }

        /**
         * List<Student> students = dao.selectStudents(); 调用
         * 1、dao对象，类型是StudentDao,全限定名称是：com.wy.dao.StudentDao
         *  全限定名称和namespace是一样的
         *
         *  2、方法名称，selectStudents，这个方法名称就是mapper文件中的id值
         *
         *  3、通过dao方法的返回值也可以确定Mybatis要调用的SqlSession的方法
         *    如果返回值是List，调用的是SqlSession.selectList()方法
         *    如果返回值int，或是非List的，栞mapper文件中的标签是<insert>,<update>就会调用
         *    SqlSession的insert，update等方法
         *
         *    mybatis的动态代理，mybatis根据dao方法嗲偶偶那个，获取执行sql语句的信息
         *      mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象
         *      完成SqlSession调用方法，访问数据库。
         *
         */

    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setAge(22);
        student.setName("小七");
        student.setId(1006);
        student.setEmail("xiaoqi@qq.com");
        int num = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println(num);
    }

    @Test
    public void testDeleteStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int id = 1006;
        int num = dao.deleteStudent(id);
        sqlSession.commit();
        System.out.println(num);
    }


}
