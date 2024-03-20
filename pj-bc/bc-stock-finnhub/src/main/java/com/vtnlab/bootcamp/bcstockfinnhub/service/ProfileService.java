package com.vtnlab.bootcamp.bcstockfinnhub.service;

import java.util.List;

import com.vtnlab.bootcamp.bcstockfinnhub.model.Profile;
import com.vtnlab.bootcamp.bcstockfinnhub.model.Symbol;

public interface ProfileService {
    Profile getProfile(String symbol);

    List<Symbol> getSymbol();
}
