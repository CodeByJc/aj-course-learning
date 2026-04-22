<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.model.Book" %>
<html>
<head>
    <title>Library - Books</title>
</head>
<body>
<h1>Books</h1>

<form action="${pageContext.request.contextPath}/book" method="post">
    <input type="hidden" name="action" value="create"/>
    Title: <input type="text" name="title" required />
    Author: <input type="text" name="author" required />
    ISBN: <input type="text" name="isbn" />
    Year: <input type="number" name="publishedYear" />
    <button type="submit">Add Book</button>
</form>

<hr/>

<% List<Book> books = (List<Book>) request.getAttribute("books"); %>
<table border="1" cellpadding="6">
    <tr><th>ID</th><th>Title</th><th>Author</th><th>ISBN</th><th>Year</th><th>Actions</th></tr>
    <% if (books != null) {
        for (Book b : books) { %>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getTitle() %></td>
                <td><%= b.getAuthor() %></td>
                <td><%= b.getIsbn() %></td>
                <td><%= b.getPublishedYear() %></td>
                <td>
                    <form action="${pageContext.request.contextPath}/book" method="post" style="display:inline">
                        <input type="hidden" name="action" value="delete" />
                        <input type="hidden" name="id" value="<%= b.getId() %>" />
                        <button type="submit">Delete</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/book" method="post" style="display:inline">
                        <input type="hidden" name="action" value="update" />
                        <input type="hidden" name="id" value="<%= b.getId() %>" />
                        Title: <input type="text" name="title" value="<%= b.getTitle() %>" />
                        Author: <input type="text" name="author" value="<%= b.getAuthor() %>" />
                        ISBN: <input type="text" name="isbn" value="<%= b.getIsbn() %>" />
                        Year: <input type="number" name="publishedYear" value="<%= b.getPublishedYear() %>" />
                        <button type="submit">Update</button>
                    </form>
                </td>
            </tr>
    <%  }
    } %>
</table>

</body>
</html>
