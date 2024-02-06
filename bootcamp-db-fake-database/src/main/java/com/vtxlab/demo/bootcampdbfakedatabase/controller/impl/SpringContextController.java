package com.vtxlab.demo.bootcampdbfakedatabase.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.bootcampdbfakedatabase.BootcampDbFakeDatabaseApplication;
import com.vtxlab.demo.bootcampdbfakedatabase.controller.BeanOperation;

@RestController
@RequestMapping(value="api/v3")
public class SpringContextController implements BeanOperation{

    // @Autowired
    // private AppConfig appConfig;

    @Autowired
    @Qualifier(value="tutor")
    private String tutorName;

    @Override
    public String[] getBeans() {
        return BootcampDbFakeDatabaseApplication.getSpringContext().getBeanDefinitionNames();
    }

    // @Override
    // public String getTutorName() {
    //     return appConfig.tutorName();
    // }

    // @Override
    // public String getTeacherName() {
    //     return appConfig.teacherName();
    // }
    @Override
    public String getTutorName(){
        return this.tutorName;
    }
}
