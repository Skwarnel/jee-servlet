package com.skwarnlab.jeeservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/Servlet32")
public class Servlet32 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String binaryNumberStr = req.getParameter("binary");
        int decimalNum = 0;
        boolean isBinary = false;
        int counter = 0;
        for (int i = 0; i < binaryNumberStr.length(); i++) {
            char c = binaryNumberStr.charAt(i);
            if (c == '0' | c == '1') {
                counter++;
            }
            if (counter == binaryNumberStr.length()) {
                isBinary = true;
            } else {
                isBinary = false;
            }
        }
        if (isBinary) {
            for (int i = binaryNumberStr.length(); i > 0; i--) {
                char c = binaryNumberStr.charAt(i - 1);
                decimalNum += Integer.parseInt(String.valueOf(c)) * Math.pow(2, binaryNumberStr.length() - i);
            }
        }

        resp.getWriter().println("Binary number: " + binaryNumberStr);
        resp.getWriter().println("equals");
        resp.getWriter().println(decimalNum);
    }
}
