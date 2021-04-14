package com.wy.dao.impl;

import com.wy.dao.Dao;
import com.wy.domain.Student;

public class DaoImplOracle implements Dao {
    @Override
    public void addService(Student student) {
        System.out.println("将数据导入到Oracle中去" + student);
    }
}
