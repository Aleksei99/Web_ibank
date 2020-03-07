<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.2020
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/save" method="POST">
    Name: <input name="name" />
    <br><br>
    Second name: <input name="second_name" />
    <br><br>
    Surname: <input name="surname" />
    <br><br>
    Birthday: <input type="date" name="birthday" />
    <br><br>
    Address: <input name="address" />
    <br><br>
    Phone number: <input name="phone_number" />
    <br><br>
    Gender: <input type="radio" name="gender" value="female" checked />Female
    <input type="radio" name="gender" value="male" />Male
    <br><br>
    Passport number: <input name="passport_number" />
    <br><br>
    Email: <input type="email" name="email" />
    <br><br>
    Password: <input type="password" name="password" />
    <br><br>
    Login: <input name="login" />
    <br><br>


    <input type="submit" value="Submit" />
</form>
</body>
</html>
