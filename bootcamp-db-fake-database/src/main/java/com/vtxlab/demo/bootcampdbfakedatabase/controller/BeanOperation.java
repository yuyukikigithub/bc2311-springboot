package com.vtxlab.demo.bootcampdbfakedatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface BeanOperation {
    @GetMapping(value="/beans")
    String[] getBeans();

    @GetMapping(value="/tutorName")
    String getTutorName();

    // @GetMapping(value="/teacherName")
    // String getTeacherName();
}
