package com.vtxlab.demo.bootcampdbfakedatabase.database;

import java.util.Arrays;

import com.vtxlab.demo.bootcampdbfakedatabase.model.Cat;

public class CatDatabase {
    private static Cat[] cats;
    private static final int dbLength=10;

    static {
        cats = new Cat[dbLength];
        cats[0] = new Cat("John", 1);
        cats[1] = new Cat("May", 2);
    }
    public static Cat getCat(int index){
        if (index<0 || index>dbLength-1) 
            throw new IllegalArgumentException();
        
        return cats[index];
    }

    public static synchronized Cat setCat(int index, Cat cat){
        if (index<0 || index>dbLength-1) 
            throw new IllegalArgumentException();
        cats[index]=cat;
        return cat;
    }

    public static synchronized Boolean deleteCat(int index){
        if (index<0 || index>dbLength-1) 
            throw new IllegalArgumentException();
        cats[index]=null;
        return cats[index]==null;
    }

    public static Cat putCat(int index, Cat cat){
        if (index<0 || index>dbLength-1) 
            throw new IllegalArgumentException();
        cats[index]=cat;
        return cat;
    }

    public static Cat patchCatName(int index, String name){
        if (index<0 || index>dbLength-1) 
            throw new IllegalArgumentException();
        cats[index].setName(name);
        return cats[index];
    }

    public static Cat patchCatAge(int index, int age){
        if (index<0 || index>dbLength-1) 
            throw new IllegalArgumentException();
        cats[index].setAge(age);
        return cats[index];
    }

    public static Cat[] getCats(){
        return cats;
    }
    public static void main(String[] args) {
        Cat[] arr = new Cat[10];
        arr[2]=new Cat("may", 2);
        arr[2]=null;
        System.out.println(Arrays.toString(arr));
    }
}
