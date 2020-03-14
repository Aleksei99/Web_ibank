<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.2020
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>iBank</title>
    <style>
        h1{
        color: orange;
    }
    input{
        margin-bottom: 10px;
        font-size: 11pt;
        padding: 15px 10px 10px;
        border: 1px solid #cecece;
        background-color: #efefef;
        color: #787575;
        border-radius: 5px;
        width: 70%;
        outline: none;
    }
    form{
        text-align: center;
        margin-top: 0;
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
    .submit{
        background-color: #3fb6b2;
        padding: 12px 45px;
        border-radius: 5px;
        cursor: pointer;
        color: #ffffff;
        border: none;
        outline: none;
        margin: 0;
        font-weight: bold;
    }
    .submit:hover{
        background-color: #43a09d;
    }
        /* Customize the label (the container) */
        .container {
            display: block;
            position: relative;
            padding-left: 35px;
            margin-bottom: 12px;
            cursor: pointer;
            font-size: 22px;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        /* Hide the browser's default radio button */
        .container input {
            position: absolute;
            opacity: 0;
            cursor: pointer;
            height: 0;
            width: 0;
        }

        /* Create a custom radio button */
        .checkmark {
            position: absolute;
            top: 0;
            left: 400px;
            height: 25px;
            width: 25px;
            background-color: #eee;
            border-radius: 50%;
        }



        /* On mouse-over, add a grey background color */
        .container:hover input ~ .checkmark {
            background-color: #ccc;
        }

        /* When the radio button is checked, add a blue background */
        .container input:checked ~ .checkmark {
            background-color: #2196F3;
        }

        /* Create the indicator (the dot/circle - hidden when not checked) */
        .checkmark:after {
            content: "";
            position: absolute;
            display: none;
        }

        /* Show the indicator (dot/circle) when checked */
        .container input:checked ~ .checkmark:after {
            display: block;
        }

        /* Style the indicator (dot/circle) */
        .container .checkmark:after {
            top: 9px;
            left: 9px;
            width: 8px;
            height: 8px;
            border-radius: 50%;
            background: white;
        }
    </style>
</head>
<body>

<form action="http://localhost:8080/login">
    <button>Log in</button>
</form>

<h1 align="center"> Registration </h1>
<form action="${pageContext.request.contextPath}/user/save" method="POST">
    <label>
    <input  required placeholder="Ваше имя" name="name" />
</label>
    <br><br>
    <input required placeholder="Отчество" name="second_name" />
    <br><br>
    <input required placeholder="Фамилия" name="surname" />
    <br><br>
    <input required  type="date" name="birthday" />
    <br><br>
    <input required placeholder="Адресс" name="address" />
    <br><br>
    <input required placeholder="+375-29-***-**-**" name="phone_number" />
    <br><br>

    <label class="container">Male
    <input type="radio" name="gender" value="male" checked >
        <span class="checkmark"></span>
    </label>

    <label class="container">Female
        <input type="radio" name="gender" value="female"  >
        <span class="checkmark"></span>
    </label>

    <br><br>
    <input required placeholder="Паспорт" name="passport_number" />
    <br><br>
    <input required placeholder="Email" type="email" name="email" />
    <br><br>
    <input required placeholder="Пароль" type="password" name="password" />
    <br><br>
    <input required placeholder="Login"  name="login" />
    <br><br>
    <input type="submit" value="Register" class="submit" />
</form>
</body>
</html>
