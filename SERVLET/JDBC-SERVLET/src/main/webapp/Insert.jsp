<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert</title>
</head>
<body>

<h2>Add Student</h2>

<form action="insert" method="post">
    Name: <input type="text" name="name" required /><br/><br/>
    Email: <input type="email" name="email" required /><br/><br/>
    Phone: <input type="text" name="phone" required /><br/><br/>

    <input type="submit" value="Save"/>
</form>

<br/>
<a href="home">Back</a>

</body>
</html>