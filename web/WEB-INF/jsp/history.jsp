<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2020
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="navigation_header.jsp" %>
<c:choose>
    <c:when test="${not empty histories}">
    <c:forEach var="history" items="${requestScope.histories}">
        <p>Number of your card :# ${history.creditCardFrom.cardNumber} Amount = ${history.spentMoney} ----> ${history.creditCardTo.cardNumber} Time of transfer = ${history.datePurchase}</p>
    </c:forEach>
    </c:when>
    <c:otherwise>You have no history yet</c:otherwise>
</c:choose>
</body>
</html>
