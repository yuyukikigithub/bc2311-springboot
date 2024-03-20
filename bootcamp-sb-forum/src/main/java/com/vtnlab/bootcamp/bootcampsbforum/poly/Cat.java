package com.vtnlab.bootcamp.bootcampsbforum.poly;

public class Cat implements Swimable, Flyable{

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fly'");
    }

    @Override
    public void swim() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swim'");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        Swimable swimableCat = cat;
        Flyable flyable = cat;
    }
    
}
