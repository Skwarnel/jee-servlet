package com.skwarnlab.jeeservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Random;

@WebServlet("/Sess37")
public class Sess37 extends HttpServlet {
    Random rand = new Random();
    int num1 = rand.nextInt(1000 - 20 + 1) + 20;
    int num2 = rand.nextInt(1000 - 20 + 1) + 20;


}
