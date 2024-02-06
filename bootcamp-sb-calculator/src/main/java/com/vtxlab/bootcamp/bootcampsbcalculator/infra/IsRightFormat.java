package com.vtxlab.bootcamp.bootcampsbcalculator.infra;

public class IsRightFormat {
    public static boolean isRightFormat(String x, String y){
        boolean result = true;
        for (int i = 0; i < x.length(); i++) {
            if ((int) x.charAt(i)==46 || ((int) x.charAt(i)<=57 && (int) x.charAt(i)>=48)) {
                continue;
            }
            return false;
        }
        for (int i = 0; i < y.length(); i++) {
            if ((int) y.charAt(i)==46 || ((int) y.charAt(i)<=57 && (int) y.charAt(i)>=48)) {
                continue;
            }
            return false;
        }
        return result;
    }
}
