package com.vtxlab.bootcamp.bootcampsbcalculator.model;

public enum OperationMethod {
    ADD("add"),
    SUB("sub"),
    MUL("mul"),
    DIV("div");

    private String op;

    
    private OperationMethod(String op){
        this.op=op;
    }

    public String getOp(){
        return this.op;
    }

    public static String getOpFmVal(String op){
        for (OperationMethod d:values()) {
            if (d.getOp().equals(op)) {
                return d.getOp();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // OperationMethod sw =  OperationMethod.ADD;
        System.out.println(OperationMethod.getOpFmVal("sub"));
        
    }
}
