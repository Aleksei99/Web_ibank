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
<%@include file="navigation_header.jsp" %>
<%--<form action="${pageContext.request.contextPath}/payments" method="get">--%>
<%--    --%>
<%--</form>--%>

<form action="${pageContext.request.contextPath}/payments" method="post">

    <select name="cards" >
        <option disabled>Choose card</option>
        <c:choose>
            <c:when test="${sessionScope.cards!=null}">
                <c:forEach var="item" items="${sessionScope.cards}">
                    <option value="${item.cardNumber}" ${item.cardNumber==sessionScope.selectedCard.intValue() ? 'selected="selected"' : ''}>
                        #${item.cardNumber}</option>
                </c:forEach>
            </c:when>
            <c:otherwise>You have no cards yet</c:otherwise>
        </c:choose>
    </select>

    <input type="number" required placeholder="Input card number" name="cardNumber">
    <br>
    <input type="number" required placeholder="Input amount" name="amount">
    <br>
    <input type="submit" value="Pay">
</form>
</body>
</html>
