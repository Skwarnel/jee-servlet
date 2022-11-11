package com.skwarnlab.jeeservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/Servlet35")
public class Servlet35 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> parameters = new ArrayList<>();
        parameters = Arrays.asList(req.getParameterValues("num"));
        double avg;
        double sum = 0;
        double product = 1;

        for (int i = 0; i < parameters.size(); i++) {
            sum += Double.parseDouble(parameters.get(i));
        }
        avg = sum / parameters.size();

        for (String d : parameters
             ) {
            product *= Double.parseDouble(d);
            System.out.println(d);
            System.out.println(product);
        }


        resp.getWriter().println("Numbers: ");
        System.out.println("<br/>");

        for (int i = 0; i < parameters.size(); i++) {
            resp.getWriter().println(" - x" + i + " = " + parameters.get(i));
        }

        resp.getWriter().println("Average:");
        System.out.println("<br/>");
        resp.getWriter().println(" - avg = " + avg);
        resp.getWriter().println("Sum:");
        System.out.println("<br/>");
        resp.getWriter().println(" - sum = " + sum);
        resp.getWriter().println("Product");
        System.out.println("<br/>");
        resp.getWriter().println(" - product = " + product);
    }
}
