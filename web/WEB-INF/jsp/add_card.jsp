<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.03.2020
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/bills/add-card" method="post">
    <p>Number of your bill:<input  required type="text" name="accountNumber"></p>
    <p>Number of your new card:<input  required type="number" name="cardNumber"></p> Month expire:<input type="number" name="month"> Year expire:<input type="number" name="year">
    <p><input type="submit" value="Add"></p>
</form>
</body>
</html>
