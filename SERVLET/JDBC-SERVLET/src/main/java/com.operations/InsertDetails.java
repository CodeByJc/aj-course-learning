package com.operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/insert")
public class InsertDetails extends HttpServlet {




    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Validation
        if (name == null || name.isEmpty() ||
                email == null || email.isEmpty() ||
                phone == null || phone.isEmpty()) {

            response.sendRedirect("Error.jsp");
            return;
        }

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO students(name, email, phone) VALUES (?, ?, ?)")) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);

            ps.executeUpdate();
            response.sendRedirect("success.jsp");

        } catch (Exception e) {
            request.setAttribute("error", "Database error");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }
}
