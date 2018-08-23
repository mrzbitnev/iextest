package com.zbitnev.iexapi.controller;

import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.zbitnev.iexapi.Main;
import com.zbitnev.iexapi.StockMaker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String result = req.getParameter("textarea");
        String resultClear = result.replaceAll("\\r|\\n|'\'| ", "");

        Main main = new Main();
        String json = main.main(resultClear);

        req.setAttribute("JSONObject", json);
        req.getRequestDispatcher("response.jsp").forward(req,resp);
    }
}
