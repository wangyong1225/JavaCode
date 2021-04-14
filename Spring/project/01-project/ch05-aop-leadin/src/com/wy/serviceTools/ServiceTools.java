package com.wy.serviceTools;

import java.util.Date;

public class ServiceTools {
    public static void myLog(){
        System.out.println("方法的执行时间"+new Date());
    }
    public static void myService(){
        System.out.println("方法结束，提交事务");
    }
}
