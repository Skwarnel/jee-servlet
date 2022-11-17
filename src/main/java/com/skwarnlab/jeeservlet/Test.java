package com.skwarnlab.jeeservlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/task?useSSL=FALSE&characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "coderslab";
    private static final String INSERT_QUERY = "INSERT INTO clients (name, email)" +
            "VALUES (?, ?);";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    public static void main(String[] args) throws SQLException {
        PreparedStatement state = connect().prepareStatement(INSERT_QUERY);
        state.setString(1, "name");
        state.setString(2, "email");
        state.executeUpdate();

    }
}

