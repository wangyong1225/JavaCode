package com.wy.service.impl;

import com.wy.service.Service;
import com.wy.serviceTools.ServiceTools;

import java.util.Date;

public class ServiceImpl implements Service {

    @Override
    public void doSome() {
        System.out.println("执行doSome()方法");

    }

    @Override
    public void doOther() {
        System.out.println("执行doOther()方法");
    }
}
