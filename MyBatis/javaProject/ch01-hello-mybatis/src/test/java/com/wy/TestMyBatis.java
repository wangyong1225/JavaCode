package com.wy;

import com.wy.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    // 测试方法，
    @Test
    public void testInsert() throws IOException {
        // 访问mybatis读取student数据
        // 1.定义mybatis主配置文件的名称，长类路径的根开始
        String config = "mybatis.xml";
        // 2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        // 3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 4.创建SqlSessionFactory对象
        SqlSessionFactory factory1 = builder.build(in);
        // 5.【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory1.openSession();
        // 6.【重要】指定要执行的sql语句的标识。SQL映射文件中的namespace+"."+标签的id值
        String sqlId = "com.wy.dao.StudentDao" + "." + "insertStudent";
        Student student = new Student();
        student.setId(1008);
        student.setName("赵六");
        student.setEmail("zhaoliu@qq.com");
        student.setAge(22);

        // 7、执行sql语句，通过sqlId找到语句
        int res = sqlSession.insert(sqlId, student);
        // mybatis不是默认提交事务的，
        sqlSession.commit();
        // 8.输出结果
        System.out.println("执行insert结果"+res);

        // 9.关闭SqlSession对象
        sqlSession.close();
    }
}
