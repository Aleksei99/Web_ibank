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
    <title>Navigation</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .navbar {
            overflow: hidden;
            background-color: #333;
            font-family: Arial, Helvetica, sans-serif;
        }

        .navbar a {
            float: left;
            font-size: 16px;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .dropdown-content a {
            float: none;
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {
            background-color: #ddd;
        }
        .navbar a:hover, .dropdown:hover .dropbtn {
            background-color: green;
        }

    </style>
</head>
<body>
<div class="navbar">
    <a href="#home">Home</a>
    <a href="#PT">Payments and transfer</a>
    <a href="#bills">Bills</a>
    <a href="#history">History</a>
</div>
</body>
</html>
