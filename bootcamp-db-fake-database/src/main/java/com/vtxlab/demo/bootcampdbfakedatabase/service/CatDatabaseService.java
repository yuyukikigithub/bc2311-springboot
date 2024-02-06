package com.vtxlab.demo.bootcampdbfakedatabase.service;

import com.vtxlab.demo.bootcampdbfakedatabase.model.Cat;

public interface CatDatabaseService {
    Cat getFromMemory(int index);

    Cat setToMemory(int index, Cat cat);

    Cat deleteMemory(int index);

    Cat putToMemory(int index, Cat cat);

    Cat patchNameToMemory(int index, String name);

    Cat patchAgeToMemory(int index, int age);

    Cat getCat(int index);
    Cat[] getAllCat();
}
