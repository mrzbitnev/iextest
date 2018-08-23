package com.zbitnev.iexapi.domain;

import java.math.BigDecimal;

public class Stock {
    private String sector;          // API IEX
    private String symbol;
    private BigDecimal volume;
    private BigDecimal latestPrice;     // API IEX


    public Stock() {
    }

    public Stock(String symbol, BigDecimal volume) {
        this.symbol = symbol;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public BigDecimal getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(BigDecimal latestPrice) {
        this.latestPrice = latestPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "sector='" + sector + '\'' +
                ", symbol='" + symbol + '\'' +
                ", volume=" + volume +
                ", latestPrice=" + latestPrice +
                '}';
    }
}
