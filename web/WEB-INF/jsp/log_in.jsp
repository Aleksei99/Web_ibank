<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.03.2020
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<c:if test="${not empty param.language}">--%>
<%--    <c:set var="language" value="${requestScope.language}" scope="session"/>--%>
<%--</c:if>--%>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="translations"/>

<html>
<head>
    <title>iBank</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        form {
            border: 3px solid #f1f1f1;
        }

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }


        .container {
            padding: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }

        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/save">
    <button><fmt:message key="login.registration"/></button>
</form>
<h2><fmt:message key="login.form"/></h2>

<form action="${pageContext.request.contextPath}/login" method="POST">

    <div class="container">
        <input type="text" placeholder="<fmt:message key="user.name"/>" name="login" required>

        <input type="password" placeholder="<fmt:message key="user.password"/>" name="psw" required>

        <button type="submit"><fmt:message key="user.submit"/></button>
    </div>

</form>

<h3><fmt:message key="user.language"/></h3>
<form action="${pageContext.request.contextPath}/login" method="get">

        <select name="language" onchange="this.form.submit() ">
        <c:forEach var="item" items="${locales}">
            <option value="${item.key}" ${item.key == param.language ? 'selected="selected"' : ''}>${item.value}</option>
        </c:forEach>
    </select>

</form>
</body>
</html>
