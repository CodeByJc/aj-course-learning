package com.operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/delete")
public class DeleteDetails extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "DELETE FROM students WHERE id=?")) {

            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();

            response.sendRedirect("home");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home");
        }
    }
}