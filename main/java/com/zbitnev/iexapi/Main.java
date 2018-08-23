package com.zbitnev.iexapi;

import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zbitnev.iexapi.controller.StockLoader;
import com.zbitnev.iexapi.domain.InvestPortf;

import java.util.List;

public class Main {
    public String main(String resultClear){

        StockMaker stockMaker = new StockMaker();
        List stocks = stockMaker.createEntity(resultClear);

        StockLoader stockLoader = new StockLoader();
        List list = stockLoader.loader(stocks);

        AllocationMaker allocationMaker = new AllocationMaker();
        InvestPortf iP = allocationMaker.allocationCreate(list);

        return jSonMaker(iP);
    }

    private String jSonMaker (InvestPortf entity){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        return json.toJson(entity);
    }
}
