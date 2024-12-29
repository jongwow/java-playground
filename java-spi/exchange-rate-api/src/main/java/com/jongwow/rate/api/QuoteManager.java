package com.jongwow.rate.api;

import java.time.LocalDate;
import java.util.List;


// Service
public interface QuoteManager {
    List<Quote> getQuotes(List<String> coins);
}
