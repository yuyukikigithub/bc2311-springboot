package com.vtnlab.bootcamp.bootcampsbforum.poly;

public interface Driver {

    int x = 2; // cannot further revise, ==> final, so should give value

    String hello3();

    default String concon(String x, String y){
        return x.concat(y);
    }

    static String concat(String x){
        return x;
    }

    // default static void conconcon(String c, String d);
} 