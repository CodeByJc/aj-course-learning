<%@ page import="java.util.List, com.operations.Student" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Student Management</h2>

<a href="Insert.jsp"><button>Add New Student</button></a>

<br/><br/>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>

    <%
        List<Student> list = (List<Student>) request.getAttribute("data");

        if (list != null) {
            for (Student s : list) {
    %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getPhone() %></td>
        <td>
            <a href="Update.jsp?id=<%= s.getId() %>">Update</a> |
            <a href="delete?id=<%= s.getId() %>"
               onclick="return confirm('Delete this record?')">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>

</table>