package com.skwarnlab.jeeservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/rememberMe")
public class Cookie36 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<html>" +
                "<body>" +
                "<form action=\"rememberMe\" method=\"POST\">" +
                "<label>" +
                "Name: " +
                "<input type=\"text\" name=\"userName\"" +
                "</label>" +
                "<label><br/>" +
                "Remember me" +
                "<input type=\"checkbox\" name=\"checked\"" +
                "</label>" +
                "<button type=\"submit\">Send</button>" +
                "</form>" +
                "</body/>" +
                "</html>");

        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("userName")) {
                resp.getWriter().println("<br/>Hi " + c.getValue());
                resp.getWriter().println("Twoje dane zostały wczytane z ciasteczka");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String checked = req.getParameter("checked");
        if (Objects.nonNull(checked)) {
            resp.getWriter().println(checked);
            Cookie cookieName = new Cookie("userName", userName);
            cookieName.setMaxAge(60*60);
            resp.addCookie(cookieName);
        } else {
            resp.getWriter().println("User rejected Cookie");
        }
    }
}
