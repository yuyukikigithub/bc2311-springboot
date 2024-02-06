package com.vtxlab.demo.bootcampdbfakedatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // @Bean
    @Bean(name="tutor")
    public String tutorName(){
        return "Vent";
    }

    // @Bean
    @Bean(name="tutor2")
    public String teacherName(){
        return "Teacher";
    }
    
}
