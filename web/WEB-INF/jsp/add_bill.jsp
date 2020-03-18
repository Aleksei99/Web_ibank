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
    <form action="${pageContext.request.contextPath}/bills/add" method="post">
        <p>Number of your new bill:<input  required type="text" name="accountNumber"></p>
        <p>Set amount $:<input  required type="number" name="amount"></p>
        <p><input type="submit" value="Add"></p>
    </form>
</body>
</html>
