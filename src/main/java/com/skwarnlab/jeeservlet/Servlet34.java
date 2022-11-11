package com.skwarnlab.jeeservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet34")
public class Servlet34 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean isVisited = false;
        for (Cookie c : cookies
        ) {
            if (c.getName().equals("visit")) {
                isVisited = true;
                int counter = Integer.parseInt(c.getValue()) + 1;
                resp.getWriter().println("Witaj, odwiedziłeś nas już " + counter + " razy");
                Cookie cookie = new Cookie("visit", String.valueOf(counter));
                cookie.setMaxAge(60 * 60 * 24 * 365);
                resp.addCookie(cookie);
            }
        }

        if (!isVisited) {
            Cookie cookieCountVisit = new Cookie("visit", "1");
            cookieCountVisit.setMaxAge(60 * 60 * 24 * 365);
            resp.addCookie(cookieCountVisit);
            resp.getWriter().println("Witaj pierwszy raz na naszej stronie");
        }
    }
}