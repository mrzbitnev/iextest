package com.zbitnev.iexapi.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Allocation {
    private String sector;
    private BigDecimal assetValue;
    private BigDecimal proportion;

    public Allocation() {
    }

    public Allocation(Stock stock) {
        setSector(stock.getSector());
        setAssetValue(stock.getLatestPrice().multiply(stock.getVolume()));
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public BigDecimal getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(BigDecimal assetValue) {
        this.assetValue = assetValue;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "sector='" + sector + '\'' +
                ", assetValue=" + assetValue +
                ", proportion=" + proportion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allocation that = (Allocation) o;
        return Objects.equals(sector, that.sector);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sector);
    }
}
