package com.jongwow.rate.impl;

import com.jongwow.rate.api.Quote;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpbitQuoteManagerImplTest {

    @Test
    public void MapResponse(){
        // GIVEN
        UpbitQuoteManagerImpl quoteManager = new UpbitQuoteManagerImpl();
        String responseStr = "[{\"market\":\"KRW-BTC\",\"timestamp\":1735407479163,\"total_ask_size\":1.08067409,\"total_bid_size\":1.73631713,\"orderbook_units\":[{\"ask_price\":142238000,\"bid_price\":142118000,\"ask_size\":0.20274867,\"bid_size\":0.00777764},{\"ask_price\":142239000,\"bid_price\":142116000,\"ask_size\":0.02688409,\"bid_size\":0.21883433},{\"ask_price\":142240000,\"bid_price\":142114000,\"ask_size\":0.63159559,\"bid_size\":0.02814641},{\"ask_price\":142241000,\"bid_price\":142109000,\"ask_size\":0.01000000,\"bid_size\":0.41103439},{\"ask_price\":142243000,\"bid_price\":142098000,\"ask_size\":0.04913622,\"bid_size\":0.00014067},{\"ask_price\":142246000,\"bid_price\":142092000,\"ask_size\":0.0200355,\"bid_size\":0.00070373},{\"ask_price\":142250000,\"bid_price\":142072000,\"ask_size\":0.01483121,\"bid_size\":0.090},{\"ask_price\":142252000,\"bid_price\":142068000,\"ask_size\":0.00010000,\"bid_size\":0.00355196},{\"ask_price\":142272000,\"bid_price\":142057000,\"ask_size\":0.01371419,\"bid_size\":0.00175759},{\"ask_price\":142289000,\"bid_price\":142054000,\"ask_size\":0.0222,\"bid_size\":0.00965},{\"ask_price\":142300000,\"bid_price\":142051000,\"ask_size\":0.07034507,\"bid_size\":0.00003520},{\"ask_price\":142309000,\"bid_price\":142050000,\"ask_size\":0.00018355,\"bid_size\":0.01460094},{\"ask_price\":142316000,\"bid_price\":142042000,\"ask_size\":0.00435,\"bid_size\":0.0046},{\"ask_price\":142323000,\"bid_price\":142041000,\"ask_size\":0.00965,\"bid_size\":0.03562790},{\"ask_price\":142326000,\"bid_price\":142040000,\"ask_size\":0.0049,\"bid_size\":0.90985637}],\"level\":0}]%";
        // WHEN
        List<Quote> map = quoteManager.maps(responseStr);
        // THEN
        assertEquals(map.size(), 1);
        Quote x = map.get(0);
        assertEquals(x.getMarket(), "KRW-BTC");
        System.out.println(x.getLocalDateTime());
    }
}