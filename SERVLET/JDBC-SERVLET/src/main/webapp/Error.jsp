<!-- error.jsp -->
<html>
<head>
  <title>Error</title>
</head>
<body>
<h2 style="color:red;">Something went wrong</h2>

<%
  String error = (String) request.getAttribute("error");
  if (error != null) {
%>
<p><%= error %></p>
<%
  }
%>

<a href="home">Try Again</a>
</body>
</html>