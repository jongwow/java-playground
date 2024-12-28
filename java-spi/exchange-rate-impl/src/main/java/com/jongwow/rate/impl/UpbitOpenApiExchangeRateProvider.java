package com.jongwow.rate.impl;

import com.jongwow.rate.api.ExchangeRateProvider;
import com.jongwow.rate.api.QuoteManager;

public class UpbitOpenApiExchangeRateProvider implements ExchangeRateProvider {
    @Override
    public QuoteManager create() {
        return new UpbitQuoteManagerImpl();
    }
}
