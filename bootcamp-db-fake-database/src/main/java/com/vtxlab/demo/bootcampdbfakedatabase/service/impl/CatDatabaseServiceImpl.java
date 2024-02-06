package com.vtxlab.demo.bootcampdbfakedatabase.service.impl;


import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.vtxlab.demo.bootcampdbfakedatabase.database.CatDatabase;
import com.vtxlab.demo.bootcampdbfakedatabase.model.Cat;
import com.vtxlab.demo.bootcampdbfakedatabase.service.CatDatabaseService;

@Service
// @Component
// create object of this class and put it into spring context
// alive until server shut down
public class CatDatabaseServiceImpl implements CatDatabaseService{

    
    // objective of service:
    // 1. locate data source
    // 2. service provided (e.g. data screening)
    
    public Cat getFromMemory(int index) {
        return CatDatabase.getCat(index);
    }

    @Override
    public Cat setToMemory(int index, Cat cat) {
        return CatDatabase.setCat(index, cat);
    }

    @Override
    public Cat deleteMemory(int index) {
        // return CatDatabase.deleteCat(index);
        if (getFromMemory(index)==null) {
            return null;
        }
        Cat deleted = getFromMemory(index);
        setToMemory(index, null);
        return deleted;
    }


    @Override
    public Cat putToMemory(int index, Cat cat) {
        // return CatDatabase.putCat(index,cat);
        // if (getFromMemory(index)==null) {
        //     return null;
        // }
        return setToMemory(index, cat);
    }

    @Override
    public Cat patchNameToMemory(int index, String name) {
        // return CatDatabase.patchCatName(index, name);
        Cat cat = getFromMemory(index);
        if (cat==null) 
            return null;
        cat.setName(name);
        return cat;
    }

    @Override
    public Cat patchAgeToMemory(int index, int age) {
        // return CatDatabase.patchCatAge(index, age);
        Cat cat = getFromMemory(index);
        if (cat==null) 
            return null;
        cat.setAge(age);
        return cat;
    }

    

    public static void main(String[] args) {
        String[] strArr = new String[10];
        strArr[2]= "onon";
        strArr[3]=String.valueOf(strArr.length);
        System.out.println(Arrays.toString(strArr));
    }

    @Override
    public Cat getCat(int index) {
        return CatDatabase.getCat(index);
    }

    @Override
    public Cat[] getAllCat() {
    return CatDatabase.getCats();
    }
}
