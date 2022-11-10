package com.skwarnlab.jeeservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/Servlet31")
public class Servlet31 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Double> currencyRatio = new HashMap<>();
        currencyRatio.put("EUR_USD", 1.02);
        currencyRatio.put("USD_EUR", 0.98);
        currencyRatio.put("EUR_PLN", 4.68);
        currencyRatio.put("PLN_EUR", 0.21);
        currencyRatio.put("USD_PLN", 0.22);
        currencyRatio.put("PLN_USD", 4.60);

        double amount = Double.parseDouble(req.getParameter("amount"));
        String currency = req.getParameter("currency");
        double amountToExchange;
        double ratio = currencyRatio.get(currency);
        amountToExchange = amount * ratio;

        resp.getWriter().append("<h2>").append(String.valueOf(amountToExchange)).append("</h2");

    }
}
