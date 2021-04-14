package com.wy;

import com.wy.domain.Study;
import com.wy.service.StudyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Date;
import java.util.List;

public class Test01 {
    @Test
    public void Test01(){
        String config= "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String names[] = ctx.getBeanDefinitionNames();
        for(String na:names){
            System.out.println("容器中对象的名称"+na+"|"+ctx.getBean(na));
        }
    }

    @Test
    public void TestQueryStudy(){
        String config= "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudyService studyService = (StudyService) ctx.getBean("studyService");
        List<Study> studies = studyService.queryStudy();
        for(Study study:studies){
            System.out.println(study);
        }

    }

    @Test
    public void TestUpdate(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudyService studyService = (StudyService) ctx.getBean("studyService");
        int num = studyService.updateStudy(3,1001);
        System.out.println(num);
    }

    @Test
    public void TestInsert(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudyService studyService = (StudyService) ctx.getBean("studyService");
        Study study = new Study();
        study.setDate(new Date());
        study.setId(1002);
        study.setTime(4);
        int num = studyService.addStudy(study);
        System.out.println(study);

    }


}
