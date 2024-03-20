package com.vtnlab.bootcamp.bcproductdata.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtnlab.bootcamp.bcproductdata.entity.CoingeckoMarketEntity;
import com.vtnlab.bootcamp.bcproductdata.entity.FinnhubProfile2Entity;
import com.vtnlab.bootcamp.bcproductdata.entity.FinnhubQuoteEntity;
import com.vtnlab.bootcamp.bcproductdata.infra.BcUtil;
import com.vtnlab.bootcamp.bcproductdata.model.CoinMarket;
import com.vtnlab.bootcamp.bcproductdata.model.Profile;
import com.vtnlab.bootcamp.bcproductdata.model.Quote;
import com.vtnlab.bootcamp.bcproductdata.model.request.CoinMarketReqDTO;
import com.vtnlab.bootcamp.bcproductdata.model.request.ProfileReqDTO;
import com.vtnlab.bootcamp.bcproductdata.model.request.QuoteReqDTO;
import com.vtnlab.bootcamp.bcproductdata.model.response.QuoteResDTO;
import com.vtnlab.bootcamp.bcproductdata.repository.CoingeckoMarketRepository;
import com.vtnlab.bootcamp.bcproductdata.repository.FinnhubProfile2Repository;
import com.vtnlab.bootcamp.bcproductdata.repository.FinnhubQuoteRepository;
import com.vtnlab.bootcamp.bcproductdata.service.FixedRateService;

@Service
public class FixedRateServiceImpl implements FixedRateService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FinnhubQuoteRepository finnhubQuoteRepository;

    @Autowired
    CoingeckoMarketRepository coingeckoMarketRepository;

    @Autowired
    FinnhubProfile2Repository finnhubProfile2Repository;

    @Override
    public boolean saveQuote() {
        QuoteReqDTO quoteReqDTO = restTemplate.getForObject(BcUtil.urlFinnhubQuote(), QuoteReqDTO.class);
        Quote quote = quoteReqDTO.getData();
        FinnhubQuoteEntity quoteResDTO = FinnhubQuoteEntity.builder()
                                            .quote_date(LocalDate.now())
                                            .quote_stock_code("AAPL")
                                            .curr_price(quote.getC())
                                            .price_chg(quote.getD())
                                            .price_chg_pct(quote.getDp())
                                            .price_day_high(quote.getH())
                                            .price_day_low(quote.getL())
                                            .price_prev_open(quote.getO())
                                            .price_prev_close(quote.getPc()).build();
        finnhubQuoteRepository.save(quoteResDTO);
        return true;
    }

    @Override
    public boolean saveCoinMarket(String coin) {
        CoinMarketReqDTO coinMarketReqDTO = restTemplate.getForObject(BcUtil.urlCoinGeckoMarket(coin), CoinMarketReqDTO.class);
        List<CoinMarket> coinMarkets; 
        if (coinMarketReqDTO.getCode()!="40000" && coinMarketReqDTO.getData()!=null){
            coinMarkets = coinMarketReqDTO.getData();
        }else {
            return false;
        }
        
        coinMarkets.stream().map(e->{
            CoingeckoMarketEntity coingeckoMarketEntity = CoingeckoMarketEntity.builder()
                                                        .quote_date(LocalDate.now())
                                                        .quote_coin_code(e.getSymbol())
                                                        .quote_currency(e.getRoiDTO()==null? "": e.getRoiDTO().getCurrency())
                                                        .name(e.getName())
                                                        .image(e.getImage())
                                                        .curr_price(e.getCurrent_price())
                                                        .market_cap(e.getMarket_cap())
                                                        .market_cap_rank(e.getMarket_cap_rank())
                                                        .fully_diluted_valuation(e.getFully_diluted_valuation())
                                                        .total_volume(e.getTotal_volume())
                                                        .high_24h(e.getHigh_24h())
                                                        .low_24h(e.getLow_24h())
                                                        .price_change_24h(e.getPrice_change_24h())
                                                        .price_change_pct_24h(e.getPrice_change_percentage_24h())
                                                        .market_cap_change_24h(e.getMarket_cap_change_24h())
                                                        .market_cap_change_pct_24h(e.getMarket_cap_change_percentage_24h())
                                                        .circulating_supply(e.getCirculating_supply())
                                                        .total_supply(e.getTotal_supply())
                                                        .max_supply(e.getMax_supply())
                                                        .ath(e.getAth())
                                                        .ath_change_percentage(e.getAth_change_percentage())
                                                        .ath_date(e.getAth_date())
                                                        .atl(e.getAtl())
                                                        .atl_change_percentage(e.getAtl_change_percentage())
                                                        .atl_date(e.getAth_date())
                                                        .build();

            coingeckoMarketRepository.save(coingeckoMarketEntity);
            return e;
        }).toList();
        
        return true;
    }

    public String isnull(Object obj){
        if (obj==null) {
            return null;
        }
        return (String) obj;
    }
    @Override
    public boolean saveProfile2(String symbol) {
        ProfileReqDTO profileReqDTO = restTemplate.getForObject(BcUtil.urlFinnhubProfile2(symbol), ProfileReqDTO.class);
        Profile profile;
        if (profileReqDTO!=null && profileReqDTO.getData()!=null) {
            profile = profileReqDTO.getData();
        }else {
            profile=null;
            return false;
        }
        
        FinnhubProfile2Entity finnhubProfile2Entity = FinnhubProfile2Entity.builder()
                                                        .quote_date(LocalDate.now())
                                                        .quote_stock_code(symbol)
                                                        .country(isnull(profile.getCountry()))
                                                        .currency(isnull(profile.getCurrency()))
                                                        .estimateCurrency(isnull(profile.getEstimateCurrency()))
                                                        .exchange(isnull(profile.getExchange()))
                                                        .finnhubIndustry(isnull(profile.getFinnhubIndustry()))
                                                        .ipo(isnull(profile.getIpo()))
                                                        .logo(isnull(profile.getLogo()))
                                                        .marketCapitalization(profile.getMarketCapitalization())
                                                        .name(isnull(profile.getName()))
                                                        // .phone(profile.getPhone())
                                                        .shareOutstanding(profile.getShareOutstanding())
                                                        .ticker(isnull(profile.getTicker()))
                                                        .weburl(isnull(profile.getWeburl()))
                                                        .build();
        finnhubProfile2Repository.save(finnhubProfile2Entity);
        return true;
    }
    
}
