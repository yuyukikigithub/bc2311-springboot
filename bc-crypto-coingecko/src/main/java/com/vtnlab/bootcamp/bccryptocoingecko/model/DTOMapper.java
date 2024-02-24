package com.vtnlab.bootcamp.bccryptocoingecko.model;

import com.vtnlab.bootcamp.bccryptocoingecko.dto.CoinsMarketsModelDTO;
import com.vtnlab.bootcamp.bccryptocoingecko.dto.CoinsMarketsModelDTO.RoiDTO;


public class DTOMapper {
    public static CoinsMarketsModelDTO coinsMarktetsModelDTOMapper(CoinsMarketsModel coinsMarketsModel){

        RoiDTO roidto = coinsMarketsModel.getRoi()==null?null:RoiDTO.builder().times(coinsMarketsModel.getRoi().getTimes())
                            .currency(coinsMarketsModel.getRoi().getCurrency())
                            .percentage(coinsMarketsModel.getRoi().getPercentage())
                            .build();
        return CoinsMarketsModelDTO.builder()
                .id(coinsMarketsModel.getId())
                .symbol(coinsMarketsModel.getSymbol())
                .name(coinsMarketsModel.getName())
                .image(coinsMarketsModel.getImage())
                .current_price(coinsMarketsModel.getCurrent_price())
                .market_cap(coinsMarketsModel.getMarket_cap())
                .market_cap_rank(coinsMarketsModel.getMarket_cap_rank())
                .fully_diluted_valuation(coinsMarketsModel.getFully_diluted_valuation())
                .total_volume(coinsMarketsModel.getTotal_volume())
                .high_24h(coinsMarketsModel.getHigh_24h())
                .low_24h(coinsMarketsModel.getLow_24h())
                .price_change_24h(coinsMarketsModel.getPrice_change_24h())
                .price_change_percentage_24h(coinsMarketsModel.getPrice_change_percentage_24h())
                .market_cap_change_24h(coinsMarketsModel.getMarket_cap_change_24h())
                .market_cap_change_percentage_24h(coinsMarketsModel.getMarket_cap_change_percentage_24h())
                .circulating_supply(coinsMarketsModel.getCirculating_supply())
                .total_supply(coinsMarketsModel.getTotal_supply())
                .max_supply(coinsMarketsModel.getMax_supply())
                .ath(coinsMarketsModel.getAth())
                .ath_change_percentage(coinsMarketsModel.getAth_change_percentage())
                .ath_date(coinsMarketsModel.getAth_date())
                .atl(coinsMarketsModel.getAtl())
                .atl_change_percentage(coinsMarketsModel.getAtl_change_percentage())
                .atl_date(coinsMarketsModel.getAtl_date())
                .roiDTO(roidto)
                .last_updated(coinsMarketsModel.getLast_updated())
                .build();
                
                
    }
}
