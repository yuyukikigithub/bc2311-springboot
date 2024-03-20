package com.vtnlab.bootcamp.bcstockfinnhub.infra;


import lombok.Getter;

@Getter
public enum Symbol {
    TSLA("tsla"),
    AAPL("aapl"),
    MSFT("msft"),
    ;
    private String abbv;

    private Symbol(String abbv){
        this.abbv=abbv;
    }
    
    public static String getSymString(String symm){
        for (Symbol sym: values()) {
            if (symm.equals(sym.getAbbv())) {
                return sym.getAbbv();
            }
        }
        return null;
    }
}
