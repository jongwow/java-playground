package com.jongwow.rate.impl;

import com.jongwow.rate.api.Quote;
import com.jongwow.rate.api.QuoteManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpbitQuoteManagerImpl implements QuoteManager {
    static final String URL_PROVIDER = "https://api.upbit.com/v1/orderbook?level=0&markets=KRW-BTC&markets=KRW-ETH&markets=KRW-XRP&KRW-DOGE";
    OkHttpClient client = new OkHttpClient();

    @Override
    public List<Quote> getQuotes(String baseCurrency, LocalDate date) {
        System.out.println("GetQuote called");
        List<Quote> quotes = new ArrayList<>();

        String response = doGetRequest(URL_PROVIDER);
        if (response != null) {
            List<Quote> maps = maps(response);
            if (maps != null) {
                quotes = maps;
            }
        }
        return quotes;
    }

    public List<Quote> maps(String response) {
        try (final Jsonb jsonb = JsonbBuilder.create()) {
            final ArrayList qrw = jsonb.fromJson(response, ArrayList.class);
            return parseResults(qrw);
        } catch (Exception e) {
            System.out.println("Error while trying to read response");
            return null;
        }
    }

    public static Quote parseResult(Map qrw) {
        Quote quote = null;
        if (qrw != null) {
            String market = (String) qrw.get("market");
            BigDecimal timestampStr = (BigDecimal) qrw.get("timestamp");
            List<Map> orderbook_units = (List<Map>) qrw.get("orderbook_units");
            BigDecimal askPrice = (BigDecimal) orderbook_units.get(0).get("ask_price");
            BigDecimal bidPrice = (BigDecimal) orderbook_units.get(0).get("bid_price");
            quote = new Quote(market, askPrice, bidPrice);
            quote.setLocalDateTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampStr.longValue()), ZoneId.systemDefault()));
        }
        return quote;
    }

    public static List<Quote> parseResults(ArrayList qrw) {
        return qrw.stream().map(a -> parseResult((Map) a)).toList();
    }

    String doGetRequest(String url) {

        System.out.println(url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return null;
        }
    }
}
