package com.skwarnlab.jeeservlet;

import java.sql.*;

public class DbUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/task?characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "coderslab";

    private static final String INSERT_QUERY = "INSERT INTO clients (name, email)" +
            "VALUES (?, ?);";

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public static void insert(Connection conn, String name, String email) {
        try (PreparedStatement statement = conn.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}