package com.zbitnev.iexapi;

import com.zbitnev.iexapi.domain.Allocation;
import com.zbitnev.iexapi.domain.InvestPortf;
import com.zbitnev.iexapi.domain.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class AllocationMaker {
    public InvestPortf allocationCreate(List <Stock> list){

        List <Allocation> listAllocation = new ArrayList<>();
        Set<Allocation> listSector = new HashSet<>();
        BigDecimal sum = new BigDecimal(0);


        for(Stock stock : list){
            Allocation all = new Allocation();
            all.setSector(stock.getSector());
            all.setAssetValue(BigDecimal.valueOf(0));
            listSector.add(all);
        }

        listAllocation.addAll(listSector);

        for (Stock stock : list){
            for (Allocation allocation : listAllocation){
                if (allocation.getSector().equals(stock.getSector())){
                    allocation.setAssetValue(allocation.getAssetValue().add((stock.getVolume().multiply(stock.getLatestPrice()))));
                }
            }
        }

        for (Allocation allocation : listAllocation){
            sum = sum.add(allocation.getAssetValue());
        }

        for (Allocation allocation : listAllocation) {
            allocation.setProportion(allocation.getAssetValue().divide(sum,3, ROUND_HALF_UP));
        }

        InvestPortf iP = new InvestPortf(sum, listAllocation);
        return iP;
    }
}

