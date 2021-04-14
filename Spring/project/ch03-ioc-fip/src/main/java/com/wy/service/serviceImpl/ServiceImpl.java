package com.wy.service.serviceImpl;

import com.wy.dao.Dao;
import com.wy.dao.impl.DaoImpl;
import com.wy.domain.Student;
import com.wy.service.Service;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service("userService")
public class ServiceImpl implements Service {

    @Autowired
    private Dao dao = new DaoImpl();

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void addService(Student student) {
        dao.addService(student);

    }
}
