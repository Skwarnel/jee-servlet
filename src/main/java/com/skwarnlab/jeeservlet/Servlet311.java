package com.skwarnlab.jeeservlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/servlet311")
public class Servlet311 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> lang = new HashMap<>();
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Hallo");
        lang.put("es", "Hola");
        lang.put("fr", "Salut");

        Cookie[] cookies = req.getCookies();
        for (Cookie c :
                cookies) {
            if (c.getName().equals("language")) {
                req.setAttribute("welcome", lang.get(c.getValue()));
                System.out.println("Attribute was set");
            }
        }

        getServletContext().getRequestDispatcher("/servlet311.jsp")
                .forward(req, resp);
    }
}
