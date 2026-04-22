package com.operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/update")
public class UpdateDetails extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");


        // Validation
        if (name == null || name.isEmpty() ||
                email == null || email.isEmpty() ||
                phone == null || phone.isEmpty() ||
                id == null || id.isEmpty()) {

            response.sendRedirect("Error.jsp");
            return;
        }
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE students SET name=?, email=?, phone=? WHERE id=?")) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setInt(4, Integer.parseInt(id));

            ps.executeUpdate();

            response.sendRedirect("home");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home"); // ✅ fixed
        }
    }
}