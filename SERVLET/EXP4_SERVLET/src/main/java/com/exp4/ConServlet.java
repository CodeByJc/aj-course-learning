package com.exp4;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ConServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String qualification = request.getParameter("qualification");

        // Handle multiple checkbox values (skills)
        String[] skillsArray = request.getParameterValues("skills");

        String skills = "";
        if (skillsArray != null) {
            skills = String.join(",", skillsArray);
        }

        // Using ServletContext (as required)
        ServletContext context = getServletContext();

        // Create DB object
        DBTransaction db = new DBTransaction();

        // Insert data into database
        db.InsertData(name, email, phone, address, gender, qualification, skills);

        // Response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Data Inserted Successfully!</h2>");
    }
}