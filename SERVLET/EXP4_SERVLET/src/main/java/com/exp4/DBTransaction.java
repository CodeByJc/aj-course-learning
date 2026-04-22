package com.exp4;

import java.sql.*;
import java.sql.*;

public class DBTransaction {

    // Method to get DB connection
    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cv",
                    "jc",
                    "Jc@25302022"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    // Method to insert data
    public void InsertData(String name, String email, String phone,
                           String address, String gender,
                           String qualification, String skills) {

        try {
            Connection con = getConnection();

            String query = "INSERT INTO cv_data(name, email, phone, address, gender, qualification, skills) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, gender);
            ps.setString(6, qualification);
            ps.setString(7, skills);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}