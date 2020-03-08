<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.03.2020
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }
    </style>
</head>
<body>
<form action="http://localhost:8080/web_war_exploded/">
    <button>Log in</button>
</form>

<form action="http://localhost:8080/web_war_exploded/user/save">
    <button>Registration</button>
</form>
</body>
</html>
