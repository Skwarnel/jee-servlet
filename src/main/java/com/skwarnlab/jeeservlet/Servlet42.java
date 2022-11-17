package com.skwarnlab.jeeservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index42")
public class Servlet42 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int[] list = new int[0];
        for (int i = 0; i < 100; i++) {
            int[] newList = new int[list.length + 1];
            for (int j = 0; j < list.length; j++) {
                newList[j] = list[j];
            }
            newList[i] = i;
            list = newList;
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        req.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/index42.jsp")
                .forward(req, resp);
    }
}
