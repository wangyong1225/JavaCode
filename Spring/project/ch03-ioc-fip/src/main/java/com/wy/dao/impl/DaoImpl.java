package com.wy.dao.impl;

import com.wy.dao.Dao;
import com.wy.domain.Student;
import org.springframework.stereotype.Repository;


@Repository("mysqlDao")
public class DaoImpl implements Dao{
    @Override
    public void addService(Student student) {
        System.out.println("将数据导入MySQL中"+student);
    }
}
