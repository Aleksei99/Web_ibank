<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.03.2020
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>iBank</title>
</head>
<body>
    <%@include file="navigation_header.jsp"%>
    <p>Welcome : ${requestScope.user.name} ${requestScope.user.secondName} ${requestScope.user.surname}</p>
</body>
</html>
