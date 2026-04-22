package com.operations;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

    private static final String url = "jdbc:mysql://localhost:3306/studentdb";
    private static final String user = "jc";
    private static final String password = "Jc@25302022";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}