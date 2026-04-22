<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    String id = request.getParameter("id");

    Connection conn = com.operations.DbUtil.getConnection();
    PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id=?");
    ps.setInt(1, Integer.parseInt(id));

    ResultSet rs = ps.executeQuery();
    rs.next();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update</title>
</head>
<body>

<h2>Update Student</h2>

<form action="update" method="post">
    <input type="hidden" name="id" value="<%= rs.getInt("id") %>"/>

    Name: <input type="text" name="name" value="<%= rs.getString("name") %>" required/><br/><br/>
    Email: <input type="text" name="email" value="<%= rs.getString("email") %>"required/><br/><br/>
    Phone: <input type="text" name="phone" value="<%= rs.getString("phone") %>"required/><br/><br/>

    <input type="submit" value="Update"/>
</form>

<br/>
<a href="home">Back</a>

</body>
</html>