package com.operations;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        java.util.List<Student> list = new java.util.ArrayList<>();

        try {
            conn = DbUtil.getConnection();
            st = conn.createStatement();

            rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
                list.add(s);
            }

            request.setAttribute("data", list);
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home");
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (st != null) st.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}