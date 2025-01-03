package com.jongwow.rate.app;

import com.jongwow.rate.api.ExchangeRate;
import com.jongwow.rate.api.Quote;

import java.time.LocalDate;
import java.util.List;

public class MainApp {
    public static void main(String... args) {
        System.out.println("Main App Started");

        ExchangeRate.providers().forEach(provider -> {
            System.out.println("Retreiving CryptoCurrency quotes from provider :" + provider);
            // Available: KRW-BTC, KRW-ETH, KRW-XRP, KRW-DOGE
            List<String> coins = List.of("KRW-BTC"); //
            System.out.println("coins: " + coins);
            List<Quote> quotes = provider.create().getQuotes(coins);
            System.out.println(String.format("%14s%12s|%12s", "","Ask", "Bid"));
            System.out.println("----------------------------------------");
            quotes.forEach(quote -> {
                System.out.println(quote.getMarket() + " : " + String.format("%12f|%12f", quote.getAskPrice(), quote.getBidPrice()));
            });
        });
    }
}
