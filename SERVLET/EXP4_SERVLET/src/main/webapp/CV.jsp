<html>
<head>
    <title>CV Form</title>
</head>
<body>

<h2>Enter Your Details</h2>

<form action="ConServlet" method="post">

    Name: <input type="text" name="name" required><br><br>

    Email: <input type="email" name="email" required><br><br>

    Phone: <input type="text" name="phone" required><br><br>

    Address: <textarea name="address" required></textarea><br><br>

    Gender:
    <input type="radio" name="gender" value="Male"> Male
    <input type="radio" name="gender" value="Female"> Female
    <br><br>

    Qualification:
    <select name="qualification">
        <option value="BSc">BSc</option>
        <option value="BCA">BCA</option>
        <option value="BTech">BTech</option>
        <option value="MCA">MCA</option>
    </select>
    <br><br>

    Skills:
    <input type="checkbox" name="skills" value="Java"> Java
    <input type="checkbox" name="skills" value="Python"> Python
    <input type="checkbox" name="skills" value="Web"> Web
    <br><br>

    <input type="submit" value="Submit">

</form>

</body>
</html>