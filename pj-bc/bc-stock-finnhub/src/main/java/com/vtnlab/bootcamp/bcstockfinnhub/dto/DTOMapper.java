package com.vtnlab.bootcamp.bcstockfinnhub.dto;

import com.vtnlab.bootcamp.bcstockfinnhub.model.Profile;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Quote;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Symbol;

public class DTOMapper {

    public static ProfileDTO profileDTOMapper(Profile profile){
        return ProfileDTO.builder()
                .country(profile.getCountry())
                .currency(profile.getCurrency())
                .estimateCurrency(profile.getEstimateCurrency())
                .exchange(profile.getExchange())
                .finnhubIndustry(profile.getFinnhubIndustry())
                .ipo(profile.getIpo())
                .logo(profile.getLogo())
                .marketCapitalization(profile.getMarketCapitalization())
                .name(profile.getName())
                .shareOutstanding(profile.getShareOutstanding())
                .ticker(profile.getTicker())
                .weburl(profile.getWeburl())
                .build();
    }

    public static QuoteDTO quoteDTOMapper(Quote quote){
        return QuoteDTO.builder()
                .c(quote.getC())
                .d(quote.getD())
                .dp(quote.getDp())
                .h(quote.getH())
                .l(quote.getL())
                .o(quote.getO())
                .pc(quote.getPc())
                .t(quote.getT())
                .build();
    }

    public static SymbolDTO symbolDTOMapper(Symbol symbol){
        return SymbolDTO.builder()
                .currency(symbol.getCurrency())
                .description(symbol.getDescription())
                .displaySymbol(symbol.getDisplaySymbol())
                .figi(symbol.getFigi())
                .isin(symbol.getIsin())
                .mic(symbol.getMic())
                .shareClassFIGI(symbol.getShareClassFIGI())
                .symbol(symbol.getSymbol())
                .symbol2(symbol.getSymbol2())
                .type(symbol.getType())
                .build();
    }
}
