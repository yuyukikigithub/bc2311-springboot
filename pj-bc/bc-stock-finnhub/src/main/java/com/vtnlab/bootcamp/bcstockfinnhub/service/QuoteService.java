package com.vtnlab.bootcamp.bcstockfinnhub.service;

import com.vtnlab.bootcamp.bcstockfinnhub.model.Quote;

public interface QuoteService {
    Quote getQuote(String sym);
}
