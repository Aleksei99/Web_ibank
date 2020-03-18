<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2020
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="navigation_header.jsp"%>
    <c:forEach var="account" items="${requestScope.accounts}">
        <p>Bill #${account.accountNumber}     amount $ ${account.amount}</p>
    </c:forEach>
    <form action="${pageContext.request.contextPath}/bills/add">
        <button>Add Bill</button>
    </form>
    <form action="${pageContext.request.contextPath}/bills/add-card">
        <button>Add Card</button>
    </form>
</body>
</html>
