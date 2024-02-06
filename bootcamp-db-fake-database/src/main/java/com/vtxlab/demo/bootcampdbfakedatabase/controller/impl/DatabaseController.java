package com.vtxlab.demo.bootcampdbfakedatabase.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.bootcampdbfakedatabase.controller.DatabaseOperation;
import com.vtxlab.demo.bootcampdbfakedatabase.model.Cat;
import com.vtxlab.demo.bootcampdbfakedatabase.service.CatDatabaseService;

// @Controller
// @ResponseBody // put result to be Body of response, if frontend HTML, no use ResponseBody
@RestController // (@Controller+@ResponseBody)
// @Component
// create object of the class and put it into spring context
// then service
@RequestMapping(value="/api/v2")
public class DatabaseController implements DatabaseOperation{

    @Autowired // (required=false) // dependency injection , give interface an object, 
    // auto locate the object which can fulfill the below interface
    private CatDatabaseService catDatabaseService; // interface of service class

    
    @Override
    public Cat getCat(int index) {
        // return new CatDatabaseServiceImpl().getFromMemory(index);
        return catDatabaseService.getFromMemory(index);
    }


    @Override
    public void setCat(int index, String name, int age) {
        //  new CatDatabaseServiceImpl().setToMemory(index, new Cat(name,age));
         catDatabaseService.setToMemory(index, new Cat(name,age));
    }


    @Override
    public Cat createCat(int idx, Cat cat) {
        return catDatabaseService.setToMemory(idx, cat);
    }


    @Override
    public Boolean deleteCat(int idx) {
        return catDatabaseService.deleteMemory(idx)!=null;
    }


    @Override
    public Cat updateCat(int idx, Cat cat) {
        return catDatabaseService.putToMemory(idx, cat);
    }


    @Override
    public Cat patchCatName(int idx, String name) {
        return catDatabaseService.patchNameToMemory(idx, name);
    }


    @Override
    public Cat patchCatAge(int idx, int age) {
        return catDatabaseService.patchAgeToMemory(idx, age);
    }


    @Override
    public List<Cat> getCats() {
        return  Arrays.stream(catDatabaseService.getAllCat()).collect(Collectors.toList());
    }


    @Override
    public Cat getCat2(int index) {
        return catDatabaseService.getFromMemory(index);
    }

}
