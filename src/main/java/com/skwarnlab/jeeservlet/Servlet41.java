package com.skwarnlab.jeeservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/index41")
public class Servlet41 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author");
        if (Objects.nonNull(author)) {
            req.setAttribute("author", author);
        } else {
            author = "lack of data";
            req.setAttribute("author", author);
        }
        getServletContext().getRequestDispatcher("/index41.jsp")
                .forward(req, resp);
    }
}
