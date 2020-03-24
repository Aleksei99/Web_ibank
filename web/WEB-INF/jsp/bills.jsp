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
    <style>
        .button {
            font: bold 11px Arial;
            text-decoration: none;
            background-color: #EEEEEE;
            color: #333333;
            padding: 2px 6px 2px 6px;
            border-top: 1px solid #CCCCCC;
            border-right: 1px solid #333333;
            border-bottom: 1px solid #333333;
            border-left: 1px solid #CCCCCC;
        }
    </style>
</head>
<body>
    <%@include file="navigation_header.jsp"%>
    <c:forEach var="account" items="${requestScope.accounts}">
        <p>ID = ${account.id} Bill #${account.accountNumber}     amount $ ${account.amount}</p>
        <ul>
        <c:forEach var="creditCard" items="${requestScope.creditCards}">
            <c:if test="${creditCard.accountId==account.id}">
                <li>AccountID= ${creditCard.accountId} Card Number = ${creditCard.cardNumber} Date expire = ${creditCard.dateExpire}</>
                <br>
                <p><a href="${pageContext.request.contextPath}/payments?cards=${creditCard.cardNumber}" class="button">P&T</a></p>
            </c:if>
        </c:forEach>
        </ul>
        <p><a href="${pageContext.request.contextPath}/bills/add-card?accountNumber=${account.accountNumber}" class="button">Add Card</a></p>
    </c:forEach>
    <form action="${pageContext.request.contextPath}/bills/add">
        <button>Add Bill</button>
    </form>

</body>
</html>
