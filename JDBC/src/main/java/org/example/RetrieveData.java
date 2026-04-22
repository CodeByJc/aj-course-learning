package org.example;

import java.sql.*;

public class RetrieveData {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "jc";
        String password = "Jc@25302022";

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            System.out.println("ID\tName\tEmail\tCourse\tMarks");
            System.out.println("------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getString("email") + "\t" +
                                rs.getString("course") + "\t" +
                                rs.getInt("marks")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}