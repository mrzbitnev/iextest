package com.zbitnev.iexapi;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.zbitnev.iexapi.controller.StockLoader;
import com.zbitnev.iexapi.domain.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StockMaker {
    private static Logger log = Logger.getLogger(StockMaker.class.getName());
    List<Stock> stocks = new ArrayList<>();

    public List<Stock> createEntity(String data){

        if (data.isEmpty()){
            log.info("Sent an empty string");
            throw new IllegalArgumentException("Sent an empty string");
        }

        JSONArray jsonArr;
        jsonArr = null;
        try {
            jsonArr  = new JSONArray(data.substring(data.indexOf(":")+1));
        } catch (JSONException e) {
            e.printStackTrace();
        }
            for (int i = 0;i < jsonArr.length(); i++){
                Stock stock = new Stock();
                try {
                    JSONObject element = jsonArr.getJSONObject(i);
                    stock.setSymbol((String) element.get("symbol"));
                    stock.setVolume(BigDecimal.valueOf(element.getInt("volume")));
                } catch (JSONException e) {
                    log.info("in string or json object data was false value ");
                    throw new IllegalArgumentException("in string or json object data was false value ");
                }
                stocks.add(stock);
            }

            return stocks;
//        StockLoader stockLoader = new StockLoader();
//        stockLoader.loader(stocks);
    }
}
