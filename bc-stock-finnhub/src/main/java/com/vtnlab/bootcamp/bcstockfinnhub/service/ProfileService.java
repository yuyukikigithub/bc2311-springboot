package com.vtnlab.bootcamp.bcstockfinnhub.service;

import com.vtnlab.bootcamp.bcstockfinnhub.model.Profile;

public interface ProfileService {
    Profile getProfile(String symbol);
}
