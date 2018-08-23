package com.zbitnev.iexapi.controller;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.zbitnev.iexapi.AllocationMaker;
import com.zbitnev.iexapi.StockMaker;
import com.zbitnev.iexapi.domain.Stock;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public class StockLoader {

    private static Logger log = Logger.getLogger(StockMaker.class.getName());

    public List<Stock> loader(List<Stock> list) {
        int buffTmp;
        JSONArray jOb = new JSONArray();

        for(Stock stock : list){
            String simbol = stock.getSymbol();
            try {
                URL url = new URL("https://api.iextrading.com/1.0/stock/" + simbol + "/quote"); //https://api.iextrading.com/1.0/stock/AAPL/quote
                HttpURLConnection httpConnect = (HttpURLConnection) url.openConnection();

                try (InputStream is=httpConnect.getInputStream()){

                    StringBuffer sB = new StringBuffer();

                    while ((buffTmp = is.read()) != -1) { sB.append((char) buffTmp);}

                    JSONObject jObject = new JSONObject(sB.toString());

                    stock.setSector(jObject.getString("sector"));
                    stock.setLatestPrice(new BigDecimal(jObject.getString("latestPrice")));
                }
            } catch(Exception e){
                log.info("some problem with ");
                e.printStackTrace();
            }
        }
    return list;
    }

}
