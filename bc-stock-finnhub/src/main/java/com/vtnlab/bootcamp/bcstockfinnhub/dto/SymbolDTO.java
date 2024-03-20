package com.vtnlab.bootcamp.bcstockfinnhub.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SymbolDTO {
    private String currency;
    private String description;
    private String displaySymbol;
    private String figi;
    private String isin;
    private String mic;
    private String shareClassFIGI;
    private String symbol;
    private String symbol2;
    private String type;

        public static void main(String[] args) {
        String dat = "2021-11-20T14:24:19.604Z";
        // System.out.println(LocalDate.of(Integer.valueOf(dat.substring(0, 4)), Integer.valueOf(dat.substring(5,7)), Integer.valueOf(dat.substring(8,10))));
        // System.out.println(dat.substring(8,10));

        Instant ins = Instant.parse(dat);
        System.out.println(LocalDate.ofInstant(ins, ZoneId.systemDefault()));
    }
}
