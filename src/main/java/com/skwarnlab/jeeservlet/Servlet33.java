package com.skwarnlab.jeeservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Servlet33")
public class Servlet33 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.isNew()) {
            resp.getWriter().println("<html>" +
                    "<body>" +
                    "<form action=\"/Servlet33\" method=\"POST\"" +
                    "<label>Pole 1" +
                    "<input type=\"text\" name=\"text1\"" +
                    "</label></br>" +
                    "<label>Pole 2" +
                    "<input type=\"text\" name=\"text2\"" +
                    "</label></br>" +
                    "<label>Pole 3" +
                    "<input type=\"text\" name=\"text3\"" +
                    "</label></br>" +
                    "<label>Pole 4" +
                    "<input type=\"text\" name=\"text4\"" +
                    "</label></br>" +
                    "<label>Pole 5" +
                    "<input type=\"text\" name=\"text5\"" +
                    "</label></br>" +
                    "<button type=\"submit\">Send</button>" +
                    "</form>" +
                    "</body>" +
                    "</html>");
        } else {
            resp.getWriter().println("<html>" +
                    "<body>" +
                    "<form action=\"/Servlet33\" method=\"POST\"" +
                    "<label>Pole 1" +
                    "<input type=\"text\" name=\"text1\" value=\"" + session.getAttribute("text1") + "\"" +
                    "</label></br>" +
                    "<label>Pole 2" +
                    "<input type=\"text\" name=\"text2\" value=\"" + session.getAttribute("text2") + "\"" +
                    "</label></br>" +
                    "<label>Pole 3" +
                    "<input type=\"text\" name=\"text3\" value=\"" + session.getAttribute("text3") + "\"" +
                    "</label></br>" +
                    "<label>Pole 4" +
                    "<input type=\"text\" name=\"text4\" value=\"" + session.getAttribute("text4") + "\"" +
                    "</label></br>" +
                    "<label>Pole 5" +
                    "<input type=\"text\" name=\"text5\" value=\"" + session.getAttribute("text5") + "\"" +
                    "</label></br>" +
                    "<button type=\"submit\">Send</button>" +
                    "</form>" +
                    "</body>" +
                    "</html>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String input1 = req.getParameter("text1");
        String input2 = req.getParameter("text2");
        String input3 = req.getParameter("text3");
        String input4 = req.getParameter("text4");
        String input5 = req.getParameter("text5");

        session.setAttribute("text1", input1);
        session.setAttribute("text2", input2);
        session.setAttribute("text3", input3);
        session.setAttribute("text4", input4);
        session.setAttribute("text5", input5);

//        resp.getWriter().println(String.valueOf(session.getAttribute("text1")));
//        resp.getWriter().println(String.valueOf(session.getAttribute("text2")));
//        resp.getWriter().println(String.valueOf(session.getAttribute("text3")));
//        resp.getWriter().println(String.valueOf(session.getAttribute("text4")));
//        resp.getWriter().println(String.valueOf(session.getAttribute("text5")));

    }
}
