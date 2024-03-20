package com.vtnlab.bootcamp.bcstockfinnhub.infra;

import lombok.Getter;

@Getter
public enum Currency {
    AED("aed"),
    AFN("afn"),
    ALL("all"),
    AMD("amd"),
    CAD("cad"),
    CDF("cdf"),
    CHF("chf"),
    CNY("cny"),
    COP("cop"),
    CRC("crc"),
    CUC("cuc"),
    CUP("cup"),
    CVE("cve"),
    CZK("czk"),
    DJF("djf"),
    DKK("dkk"),
    DOP("dop"),
    DZD("dzd"),
    EGP("egp"),
    ERN("ern"),
    ETB("etb"),
    EUR("eur"),
    GBP("gbp"),
    JPY("jpy"),
    MDL("mdl"),
    MGA("mga"),
    USD("usd"),
    ;

    private String currency;

    private Currency(String currency){
        this.currency=currency;
    }

    public static String getCurrency(String currency){
        for ( Currency cur : values()) {
            if(cur.getCurrency().equals(currency))
                return currency;
        }
        return null;
    }
}
