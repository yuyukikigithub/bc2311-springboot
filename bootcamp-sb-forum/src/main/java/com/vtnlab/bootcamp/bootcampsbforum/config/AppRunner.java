package com.vtnlab.bootcamp.bootcampsbforum.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vtnlab.bootcamp.bootcampsbforum.service.GovService;

// @Autowired
// private CommandLineRunner commandLineRunner;

// @Component
public class AppRunner implements CommandLineRunner{

    @Autowired
    private GovService govService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("helloworld");

        // main teask in apprunner
        // 1. checking on configuration -DB or yml
        // 2. invoke API to get data (ie configuration row data)

        // call JPH -> get users -> refresh DB delete & insert
        // RestClientException -> throw exception
        govService.getUsers();

    }


}
