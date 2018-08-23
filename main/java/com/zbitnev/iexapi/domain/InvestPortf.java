package com.zbitnev.iexapi.domain;

import java.math.BigDecimal;
import java.util.List;

public class InvestPortf {

    private BigDecimal value;
    private List<Allocation> allocations;


    public InvestPortf(BigDecimal value, List<Allocation> allProf) {
        this.value = value;
        this.allocations = allProf;
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value + "\n" +
                "allocations= " + "\n" + allocations +
                '}';
    }
}
