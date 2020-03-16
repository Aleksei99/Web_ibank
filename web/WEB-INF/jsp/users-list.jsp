<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.03.2020
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="user" items="${requestScope.users}">
    <p><a href="${pageContext.request.contextPath}/user/search?id=${user.id}">${user.name}</a></p>
</c:forEach>
</body>
</html>
