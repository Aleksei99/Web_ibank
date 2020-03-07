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
    <title>Registration form</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/save" method="POST">
    Name: <input required placeholder="Ваше имя" name="name" />
    <br><br>
    Second name: <input required placeholder="Отчество" name="second_name" />
    <br><br>
    Surname: <input required placeholder="Фамилия" name="surname" />
    <br><br>
    Birthday: <input required  type="date" name="birthday" />
    <br><br>
    Address: <input required placeholder="Адресс" name="address" />
    <br><br>
    Phone number: <input required placeholder="+375-29-***-**-**" name="phone_number" />
    <br><br>
    Gender: <input type="radio" name="gender" value="female" checked />Female
    <input type="radio" name="gender" value="male" />Male
    <br><br>
    Passport number: <input required placeholder="Паспорт" name="passport_number" />
    <br><br>
    Email: <input required type="email" name="email" />
    <br><br>
    Password: <input required type="password" name="password" />
    <br><br>
    Login: <input required name="login" />
    <br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
