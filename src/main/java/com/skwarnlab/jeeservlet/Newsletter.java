package com.skwarnlab.jeeservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/newsletter")
public class Newsletter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie formDisplayed = new Cookie("dis", "true");
        formDisplayed.setMaxAge(60*60*24);
        resp.addCookie(formDisplayed);
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        System.out.println(name);
        System.out.println(email);
        try {
            Connection connection = DbUtil.connect();
            DbUtil.insert(connection, name, email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        getServletContext().getRequestDispatcher("/newsletterContent.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean formSent = false;
        Cookie[] cookies = req.getCookies();
        for (Cookie c :
                cookies) {
            if (c.getName().equals("dis")) {
                formSent = true;
            } else {
                formSent = false;
            }
        }

        if (formSent == true) {
            getServletContext().getRequestDispatcher("/newsletterContent.jsp")
                    .forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/newsletter.jsp")
                    .forward(req, resp);
        }

    }
}
