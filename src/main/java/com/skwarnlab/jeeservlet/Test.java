package com.skwarnlab.jeeservlet;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rand = new Random();
        int num1 = rand.nextInt(10+1) -1;
        int num2 = rand.nextInt(10);
        int num3 = rand.nextInt(10);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}

