package com.jongwow.rate.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Quote { // 호가
    private String market;

    private BigDecimal askPrice;
    private BigDecimal bidPrice;
    private LocalDateTime localDateTime;
    public Quote(String market, BigDecimal askPrice, BigDecimal bidPrice) {
        this.market = market;
        this.askPrice = askPrice;
        this.bidPrice = bidPrice;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public BigDecimal getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(BigDecimal askPrice) {
        this.askPrice = askPrice;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
