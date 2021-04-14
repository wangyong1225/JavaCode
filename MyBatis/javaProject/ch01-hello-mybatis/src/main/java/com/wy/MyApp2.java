package com.wy;

import com.wy.domain.Student;
import com.wy.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {



        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 6.【重要】指定要执行的sql语句的标识。SQL映射文件中的namespace+"."+标签的id值
        String sqlId = "com.wy.dao.StudentDao" + "." + "selectStudents";
        // 7、执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        // 8.输出结果
        studentList.forEach(stu -> System.out.println(stu));
        // 9.关闭SqlSession对象
        sqlSession.close();
    }
}

